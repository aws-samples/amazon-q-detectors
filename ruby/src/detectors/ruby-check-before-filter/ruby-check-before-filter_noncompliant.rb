# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-before-filter@v1.0 defects=1}
class AdminController < ApplicationController
  # Noncompliant: Using `:except` creates a blacklist approach which can miss securing new actions.
  skip_before_filter :authenticate_admin, :except => :sensitive_action

  def noncompliant
    render json: { message: "Unprotected action" }
  end

  def sensitive_action
    render json: { admin_data: "sensitive" }
  end
end
# {/fact}
