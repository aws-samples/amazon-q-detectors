# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-tainted-format@v1.0 defects=0}
class UsersController < ActionController

    def show
      # Compliant: The format string is not tainted. 
      Kernel.printf("User ID: %d Username: %s", params[:id], params[:username])
    end
end
# {/fact}
