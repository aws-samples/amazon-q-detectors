# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-dangerous-subshell@v1.0 defects=0}
class HomeController < ApplicationController
    def compliant 
        text = params[:text]  
        if text !~ /\A[\w]+\z/
            # Compliant: The `text` variable is validated for an expected format before being passed to the shell command. 
            result = `simple-math "#{text}" 2> /dev/null`.strip
            puts text + " = " + result
        end
    end
end
# {/fact}
