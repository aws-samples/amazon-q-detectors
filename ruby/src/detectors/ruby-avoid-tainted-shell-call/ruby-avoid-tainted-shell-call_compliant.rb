# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-tainted-shell-call@v1.0 defects=0}
require 'shellwords'

class FileController < ApplicationController
  def compliant
    filename = params[:filename]
    # Compliant: Using `Shellwords.escape` to sanitize user input before shell execution.
    safe_filename = Shellwords.escape(filename)
    result = `ls -la #{safe_filename}`
    render plain: result
  end
end
# {/fact}
