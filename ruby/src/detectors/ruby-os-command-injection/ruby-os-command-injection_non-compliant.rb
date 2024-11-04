# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-os-command-injection@v1.0 defects=1}
class UsersController < ActionController::Base
  def noncompliant 
    read_file = params[:read_this_file]
    # Noncompliant: Using user controlled input directly in an external command.
    file_content = system("cat #{read_file}")
    render plain: file_content
  end
end
# {/fact}
