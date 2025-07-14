# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-scripting-ide@v1.0 defects=1}
class MessagesController < ApplicationController
  def noncompliant
    user_message = params[:message]
    # Noncompliant: Rendering user input directly without escaping can lead to XSS attacks.
    render inline: "<div class='message'>#{user_message}</div>"
  end
end
# {/fact}
