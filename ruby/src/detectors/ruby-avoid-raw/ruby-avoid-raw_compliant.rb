# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-raw@v1.0 defects=0}
require 'action_view'

class PostsController < ApplicationController
  include ActionView::Helpers::SanitizeHelper
  
  def compliant
    user_content = params[:content]
    # Compliant: Using sanitize() to clean user input before rendering.
    @post_content = sanitize(user_content)
    render :show
  end
end
# {/fact}
