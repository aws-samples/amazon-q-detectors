# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-unvalidated-url-redirect@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant
        user_status = params[:user_validated]

        if user_status == "VALID"
            # Compliant: URL is validated before redirection.
            redirect_to "https://example.com" 
        else
            render plain: "User validation failed."
        end
    end
end
# {/fact}
