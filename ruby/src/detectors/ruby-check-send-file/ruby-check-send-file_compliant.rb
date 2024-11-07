# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-send-file@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant 
        file_to_send = params[:file]

        sanitized_file_name = File.basename(file_to_send)

        safe_path = Rails.root.join('public/files', sanitized_file_name)

        if File.exist?(safe_path)
            # Compliant: Sending a file after proper validation.
            send_file safe_path
        else
            render plain: "File not found or invalid path", status: :not_found
        end
    end
end
# {/fact}
