# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection@v1.0 defects=1}
require 'active_record'

class UsersController < ApplicationController
  def noncompliant
    user_id = params[:user_id]
    # Noncompliant: Direct string interpolation in SQL queries can lead to SQL injection attacks.
    query = "SELECT * FROM users WHERE id = #{user_id}"
    result = ActiveRecord::Base.connection.execute(query)
    result
  end
end
# {/fact}
