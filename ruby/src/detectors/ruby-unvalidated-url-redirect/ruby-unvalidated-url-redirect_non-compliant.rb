# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=1}
class UsersController < ActionController::Base
  def noncompliant
    user_id = params[:user_id]
    redirect_url = params[:redirect_url]
    
    # Process user login
    user = User.find(user_id)
    if user&.authenticate(params[:password])
      session[:user_id] = user.id
      flash[:notice] = "Login successful"
      
      # Noncompliant: Redirecting to user-provided URLs without validation can lead to open redirect attacks.
      redirect_to params
    else
      flash[:error] = "Invalid credentials"
      redirect_to login_path
    end
  end
  
  def route1
    # Noncompliant: Direct redirect to params
    redirect_to params
  end
  
  def route2
    # Noncompliant: Redirect to user-controlled parameter
    redirect_to params[:key]
  end
end
# {/fact}
