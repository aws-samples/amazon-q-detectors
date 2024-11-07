# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-stack-trace-exposure@v1.0 defects=1}
class FooController < ApplicationController

    def something_that_might_fail
        # do something
    end

    def show
        something_that_might_fail
    rescue => e
        # Noncompliant: Exposes full exception backtrace to the client.
        render body: e.backtrace, content_type: "text/plain"
    end
end
# {/fact}
