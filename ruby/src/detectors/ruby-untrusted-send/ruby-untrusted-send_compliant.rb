# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-send@v1.0 defects=0}
class HomeController < ApplicationController

    def compliant 
        method = params[:method] == 1 ? :method_a : :method_b

        # Compliant: User input is properly validated before using it.
        @result = User.send(method)
    end

end
# {/fact}
