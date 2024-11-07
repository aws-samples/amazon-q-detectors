# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-tainted-file-access@v1.0 defects=0}
class UsersController < ApplicationController
    def compliant
        path_to_validate = File.basename(params[:file_id])

        # Compliant: User input is sanitized before use in `File.open(...)`.
        File.open(path_to_validate, 'r') do |file|
            first_line = file.readline.strip
    
            if first_line == 'VALID'
              render plain: 'success'
            else
              render plain: 'invalid'
            end
        end
    end
end
# {/fact}
