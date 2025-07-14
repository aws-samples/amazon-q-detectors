# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-log-injection-ide@v1.0 defects=0}
require 'logger'

class AuthController < ApplicationController
  def compliant
    username = params[:username]
    logger = Logger.new(STDOUT)
    # Compliant: Sanitizing user input before logging to prevent log injection.
    safe_username = sanitize_for_log(username)
    logger.info("Login attempt for user: #{safe_username}")
    render json: { status: 'logged' }
  end
  
  private
  
  def sanitize_for_log(input)
    # Remove newlines and control characters that could be used for log injection
    input.to_s.gsub(/[\r\n\t]/, '_').strip
  end
end
# {/fact}
