# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-subshell@v1.0 defects=1}
class HomeController < ApplicationController
    def put_command 
        text = params[:text]  
        result = `simple-math "#{text}" 2> /dev/null`.strip
        noncompliant(result)
    end

    def noncompliant(user_input)
        # Noncompliant: Using backticks (`) to execute shell commands.
        result = `foo #{user_input} bar`
    end
end
# {/fact}
