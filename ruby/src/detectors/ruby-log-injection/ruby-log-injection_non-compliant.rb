# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-log-injection@v1.0 defects=1}
require 'logger'

class UsersController < ApplicationController

    def init_logger
        if @logger == nil
          @logger = Logger.new STDOUT
        end
    end

    def noncompliant 
        init_logger
        username = params[:username]

        # Noncompliant: Unsanitized user input is logged without proper sanitization.
        @logger.info "User created: #{username}"
    end
end
# {/fact}
