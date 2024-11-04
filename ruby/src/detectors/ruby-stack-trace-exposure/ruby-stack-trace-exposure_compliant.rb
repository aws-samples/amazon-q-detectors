# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-stack-trace-exposure@v1.0 defects=0}
class FooController < ApplicationController

    def something_that_might_fail
      # do something
    end

    def show
      something_that_might_fail
    rescue => e
      # Compliant: Does not expose full stack trace. 
      render body: "An error occurred. Please try again later", content_type: "text/plain"
    end

end
# {/fact}
