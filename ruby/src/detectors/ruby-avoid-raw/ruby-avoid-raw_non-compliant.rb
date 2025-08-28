# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-raw@v1.0 defects=1}
require 'action_view'

class PostsController < ApplicationController
  include ActionView::Helpers::OutputSafetyHelper
  
  def noncompliant
    user_content = params[:content]
    # Noncompliant: Using `raw()` with user input can lead to XSS vulnerabilities.
    @post_content = raw(user_content)
    render :show
  end
end
# {/fact}
