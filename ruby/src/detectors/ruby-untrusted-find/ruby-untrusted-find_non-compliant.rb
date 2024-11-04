# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-find@v1.0 defects=1}
class HomeController < ApplicationController

    def noncompliant 
        # Noncompliant: User controlled is used to find a value directly. 
        @user = Accounts.find(params[:id])
    end

end
# {/fact}
