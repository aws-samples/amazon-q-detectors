# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unsafe-html@v1.0 defects=0}
require 'action_view'
require 'erb'

class UsersController < ApplicationController
  def compliant
    username = params[:username]
    # Compliant: Using `ERB::Util.html_escape` to sanitize user input before marking as `html_safe`.
    content = "<div>Welcome, #{ERB::Util.html_escape(username)}</div>".html_safe
    render inline: content
  end
end
# {/fact}
