# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-log-injection-ide@v1.0 defects=1}
require 'logger'

class AuthController < ApplicationController
  def noncompliant
    username = params[:username]
    logger = Logger.new(STDOUT)
    # Noncompliant: Logging user input directly can lead to log injection attacks.
    logger.info("Login attempt for user: #{username}")
    render json: { status: 'logged' }
  end
end
# {/fact}
