# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-before-filter@v1.0 defects=1}
class AdminController < ApplicationController
  # Noncompliant: Using :except creates a blacklist approach which can miss securing new actions
  skip_before_filter :authenticate_admin, :except => :sensitive_action

  def noncompliant
    # This action is unprotected due to blacklist approach
    render json: { message: "Unprotected action" }
  end

  def sensitive_action
    # This action requires admin authentication
    render json: { admin_data: "sensitive" }
  end
end
# {/fact}
