# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-send-file@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant 
        file_to_send = params[:file]

        # Noncompliant: Sending a file from the server to the client without validation.
        send_file file_to_send 
    end
end
# {/fact}
