# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unsafe-html@v1.0 defects=1}
require 'action_view'

class UsersController < ApplicationController
  def noncompliant
    username = params[:username]
    # Noncompliant: Using html_safe with unsanitized user input exposes the application to XSS attacks.
    content = "<div>Welcome, #{username}</div>".html_safe
    render inline: content
  end
end
# {/fact}
