# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection@v1.0 defects=0}
require 'active_record'

class UsersController < ApplicationController
  def compliant
    user_id = params[:user_id]
    # Compliant: Using parameterized queries to prevent SQL injection attacks.
    result = User.where("id = ?", user_id)
    result
  end
end
# {/fact}
