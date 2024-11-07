# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-sensitive-http-action@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        def login 
            # Noncompliant: Avoid this pattern of 'get' and 'others' , since 'head' requests can also be a part of a 'get' request.
            if request.get?  
                do_get 
            else 
                do_post
            end 
        end
    end
end
# {/fact}
