# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection-ide@v1.0 defects=0}
require 'sqlite3'

class ReportsController < ApplicationController
  def compliant
    user_id = params[:user_id]
    db = SQLite3::Database.new("database.db")
    
    # Compliant: Using parameterized queries to prevent SQL injection attacks.
    query = "SELECT * FROM reports WHERE user_id = ?"
    results = db.execute(query, [user_id])
    
    render json: results
  end
end
# {/fact}
