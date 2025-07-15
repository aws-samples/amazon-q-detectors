# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=0}
class UsersController < ActionController::Base
  def compliant
    key = params[:redirect_url]
    
    # Compliant: Validating redirect URL against specific allowed values.
    if key == "dashboard"
      redirect_to "/dashboard"
    elsif key == "profile"
      redirect_to "/profile"
    else
      redirect_to "/default"
    end
  end
end
# {/fact}
