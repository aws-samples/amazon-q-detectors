# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-untrusted-find@v1.0 defects=0}
class HomeController < ApplicationController

    def get_stored_user
        # Retrieve and return `user`
        User.find(session[:user_id])
    end

    def noncompliant 
        @user = get_stored_user
        
        # Compliant: Use user data to search within the context of a pre-existing user.
        @user.accounts.find(params[:id])
    end
    
end
# {/fact}
