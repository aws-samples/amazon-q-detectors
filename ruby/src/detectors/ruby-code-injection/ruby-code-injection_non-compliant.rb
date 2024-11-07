# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-code-injection@v1.0 defects=1}
class HomeController < ApplicationController
    def noncompliant 
        code = params[:user_code]
        # Noncompliant: User controlled input is being dynamically compiled and executed.
        iseq = RubyVM::InstructionSequence.compile(code)
    end
end
# {/fact}
