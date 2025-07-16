# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-link-to@v1.0 defects=1}
class UserController < ApplicationController
  def noncompliant
    user_url = params[:url]
    
    # Noncompliant: Using user input directly in link_to can lead to XSS attacks.
    link_to "Click here", user_url
  end
end
# {/fact}
