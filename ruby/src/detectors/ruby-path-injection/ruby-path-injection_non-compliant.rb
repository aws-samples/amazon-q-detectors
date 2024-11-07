# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-path-injection@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        path = params[:path]  

        # Noncompliant: Unsanitized user input is used to read a file.
        @content = File.read(path)

        render plain:@content
    end
end
# {/fact}
