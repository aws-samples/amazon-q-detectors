# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-request-forgery@v1.0 defects=1}
class ApplicationController < ActionController::Base
  # Noncompliant: CSRF protection is disabled, making the application vulnerable to CSRF attacks.
  skip_before_action :verify_authenticity_token
  
  def noncompliant
    # Sensitive action without CSRF protection
    user_id = params[:user_id]
    User.find(user_id).destroy
    redirect_to users_path
  end
end
# {/fact}
