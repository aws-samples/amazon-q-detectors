# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-scripting-ide@v1.0 defects=0}
require 'erb'

class MessagesController < ApplicationController
  def compliant
    user_message = params[:message]
    # Compliant: Using `ERB::Util.html_escape` to sanitize user input before rendering.
    safe_message = ERB::Util.html_escape(user_message)
    render inline: "<div class='message'>#{safe_message}</div>"
  end
end
# {/fact}
