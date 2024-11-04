# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-code-injection@v1.0 defects=0}
class HomeController < ApplicationController

    def get_dynamic_code
        # Retrieve dynamic code from a verifiable source, like the db or a predefined file.
    end


    def compliant 
        code = get_dynamic_code 
        # Compliant: The code being executed dynamically does not come from user controlled input.
        iseq = RubyVM::InstructionSequence.compile(code)
        render plain: iseq.eval
    end
end
# {/fact}
