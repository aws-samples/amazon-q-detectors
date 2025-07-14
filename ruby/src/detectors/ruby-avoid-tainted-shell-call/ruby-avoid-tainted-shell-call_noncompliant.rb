# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-tainted-shell-call@v1.0 defects=1}
class FileController < ApplicationController
  def noncompliant
    filename = params[:filename]
    # Noncompliant: Using user input directly in shell commands can lead to command injection attacks.
    result = `ls -la #{filename}`
    render plain: result
  end
end
# {/fact}
