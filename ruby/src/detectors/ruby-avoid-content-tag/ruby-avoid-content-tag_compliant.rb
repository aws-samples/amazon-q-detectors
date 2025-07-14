# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-content-tag@v1.0 defects=0}
class UserController < ApplicationController
  def compliant
    user_input = params[:comment]
    
    # Compliant: Using safe HTML generation without content_tag
    tag.div(h(user_input), class: "comment")
  end
end
# {/fact}
