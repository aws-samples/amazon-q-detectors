# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-send@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        method = params[:method]

        # Noncompliant: Untrusted input is passed to `send`.
        @result = User.send(method.to_sym)
    end

end
# {/fact}
