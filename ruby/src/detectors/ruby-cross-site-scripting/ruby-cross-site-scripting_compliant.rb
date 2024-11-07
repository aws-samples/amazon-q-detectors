# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-scripting@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant
        welcome_message = strip_tags(params[:message])

        # Compliant: Data has been sanitized before using it within `render`.
        render inline: "<div>#{welcome_message}</div>"
    end
end
# {/fact}
