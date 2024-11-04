# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-unsafe-reflection@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        table = params["table"]

        # Noncompliant: Reflection is used to call a method dynamically.
        model = table.classify.constantize

        @result = model.send(:method)
    end
end
# {/fact}
