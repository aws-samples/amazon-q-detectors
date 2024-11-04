# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-render-dynamic-path@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant 
        welcome_template = "users/welcome" 

        # Compliant: The ERB template name is set to the template to be rendered.
        render template: welcome_template 
    end
end
# {/fact}
