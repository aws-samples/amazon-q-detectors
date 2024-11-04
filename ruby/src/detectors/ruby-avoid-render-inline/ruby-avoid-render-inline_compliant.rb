# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-render-inline@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant 
        @name = "Guest"
        # Compliant: Use a pre-defined ERB `template`.
        render template: 'users/show'
    end
end
# {/fact}
