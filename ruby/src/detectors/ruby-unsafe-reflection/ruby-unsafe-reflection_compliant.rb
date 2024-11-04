# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-unsafe-reflection@v1.0 defects=0}
class HomeController < ApplicationController

    def compliant 
        table = "UserTable"

        # Compliant: No usage of untrusted input.
        model = table.classify.constantize
    
        @result = model.send(:method)
    end
end
# {/fact}
