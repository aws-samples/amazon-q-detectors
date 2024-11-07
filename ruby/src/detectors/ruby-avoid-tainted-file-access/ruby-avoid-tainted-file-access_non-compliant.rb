# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-tainted-file-access@v1.0 defects=1}
class UsersController < ApplicationController
    def noncompliant
        path_to_validate = "/tmp/validity_" + params[:file_id]

        # Noncompliant: User-provided data is used to construct a file path without proper sanitization.
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
