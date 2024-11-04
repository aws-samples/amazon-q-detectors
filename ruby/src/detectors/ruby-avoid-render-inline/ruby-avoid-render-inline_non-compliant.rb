# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-render-inline@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant 
        # Noncompliant: Avoid using `inline`.
        render inline: "<h1>Hello Guest !</h1>"
    end
end
# {/fact}
