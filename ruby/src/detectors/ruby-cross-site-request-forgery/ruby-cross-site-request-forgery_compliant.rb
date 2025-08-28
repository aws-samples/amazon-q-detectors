# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-request-forgery@v1.0 defects=0}
class ApplicationController < ActionController::Base
  # Compliant: `CSRF` protection is enabled by default to prevent CSRF attacks.
  protect_from_forgery with: :exception
  
  def compliant
    user_id = params[:user_id]
    User.find(user_id).destroy
    redirect_to users_path
  end
end
# {/fact}
