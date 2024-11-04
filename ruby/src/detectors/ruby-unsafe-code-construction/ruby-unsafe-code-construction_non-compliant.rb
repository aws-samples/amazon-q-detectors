# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-unsafe-code-construction@v1.0 defects=1}
class FooController < ApplicationController

    def run_code
        code = params[:code]
        noncompliant(code)
    end


    def noncompliant(target)
        # Noncompliant: `eval` is used for dynamic code execution without validation.
        eval("foo = #{target}") 
    end

end
# {/fact}
