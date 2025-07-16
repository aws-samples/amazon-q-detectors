# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection-ide@v1.0 defects=1}
require 'sqlite3'

class ReportsController < ApplicationController
  def noncompliant
    user_id = params[:user_id]
    db = SQLite3::Database.new("database.db")
    
    # Noncompliant: Direct string interpolation in SQL queries can lead to SQL injection attacks.
    query = "SELECT * FROM reports WHERE user_id = #{user_id}"
    results = db.execute(query)
    
    render json: results
  end
end
# {/fact}
