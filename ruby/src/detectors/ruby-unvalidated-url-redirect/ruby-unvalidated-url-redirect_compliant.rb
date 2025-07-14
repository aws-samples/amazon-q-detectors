# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=0}
class UsersController < ActionController::Base
  def compliant
    user_id = params[:user_id]
    key = params[:key]
    
    # Process user login
    user = User.find(user_id)
    if user&.authenticate(params[:password])
      session[:user_id] = user.id
      flash[:notice] = "Login successful"
      
      # Compliant: Validating redirect parameter against specific allowed values
      if key == "dashboard"
        redirect_to "/dashboard"
      elsif key == "profile"
        redirect_to "/profile"
      else
        redirect_to "/default"
      end
    else
      flash[:error] = "Invalid credentials"
      redirect_to login_path
    end
  end
  
  def route8
    key = params[:key]
    if key == "foo"
      # Compliant: Only allowing specific, validated redirect values
      redirect_to key
    else
      redirect_to "/default"
    end
  end
end
# {/fact}
