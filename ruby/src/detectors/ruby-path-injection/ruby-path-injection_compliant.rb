# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-path-injection@v1.0 defects=0}
class HomeController < ApplicationController

    def compliant 
        filename = File.basename(params[:path])
        path = Rails.root.join('your_directory', filename)
  
        # Compliant: The use controller value in 'path' has been sanitized.
        if File.exist?(path)
            @content = File.read(path) 
            render plain: @content
        else
            render plain: "File not found", status: :not_found 
        end
    end
end
# {/fact}
