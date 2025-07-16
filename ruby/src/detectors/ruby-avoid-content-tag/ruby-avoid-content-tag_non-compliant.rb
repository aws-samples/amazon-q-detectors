# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-content-tag@v1.0 defects=1}
class UserController < ApplicationController
  def noncompliant
    user_input = params[:comment]
    
    # Noncompliant: Using `content_tag` with user input can lead to XSS attacks.
    content_tag(:div, user_input, class: "comment")
  end
end
# {/fact}
