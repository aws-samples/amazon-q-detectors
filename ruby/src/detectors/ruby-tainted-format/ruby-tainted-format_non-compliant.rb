# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-tainted-format@v1.0 defects=1}
class UsersController < ActionController::Base

    def show
      # Noncompliant: Tainted code used as a `printf` format string.
      Kernel.printf(params[:format], 1, "username")
    end
end
# {/fact}
