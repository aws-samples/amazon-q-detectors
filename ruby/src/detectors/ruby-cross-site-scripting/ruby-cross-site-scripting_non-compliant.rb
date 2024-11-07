# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-cross-site-scripting@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant
        welcome_message = params[:message]

        # Noncompliant: User controlled data being returned directly without any sanitization.
        render inline: "<div>#{welcome_message}</div>"
    end
end
# {/fact}
