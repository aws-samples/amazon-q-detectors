# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant
        url = params[:url] 
        # Noncompliant: User-provided URL is not validated before redirect.
        redirect_to url 
    end
end
# {/fact}
