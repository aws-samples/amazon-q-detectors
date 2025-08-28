# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-link-to@v1.0 defects=0}
class UserController < ApplicationController
  def compliant
    user_url = params[:url]
    
    # Compliant: Using hardcoded URL instead of user input.
    link_to "Click here", "/safe/path"
  end
end
# {/fact}
