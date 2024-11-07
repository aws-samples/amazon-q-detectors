# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-unsafe-code-construction@v1.0 defects=0}
class FooController < ApplicationController

    def compliant 

        # Compliant: User input is used indirectly for validation.
        code = params[:command]

        k = 0

        if command == "assign"
          eval("k = 10")
        elsif command == "increment"
          eval("k += 10")
        elsif command == "multiply"
          eval("k *= 10")
        elsif command == "divide"
          eval("k /= 10") unless k.zero?
        else
          return "Invalid command"
        end

        render plain: "The value of k is: #{k}"
    end
end
# {/fact}
