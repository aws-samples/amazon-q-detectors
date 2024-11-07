# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-render-dynamic-path@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant 
        welcome_template = params[:welcome_template] 

        # Noncompliant: User controlled input used to select the template to display.
        render template: welcome_template 
    end
end
# {/fact}
