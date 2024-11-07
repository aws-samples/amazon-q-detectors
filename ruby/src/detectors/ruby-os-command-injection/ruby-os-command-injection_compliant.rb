# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-os-command-injection@v1.0 defects=0}
class UsersController < ActionController::Base
    def compliant 
        read_file = params[:read_this_file]
    
        filename = File.basename(read_file)
        path = Rails.root.join('your_directory', filename)

    if File.exist?(path)
        # Compliant: Avoid using shell commands.
        file_content = File.read(path)
        render plain: file_content
    else
        render plain: "File not found", status: :not_found
    end
  end
end
# {/fact}
