# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-sql-injection-pg@v1.0 defects=1}
require 'pg'

class UsersController < ApplicationController

    def get_db
      # return db
    end

    def get_username
      # return the username
    end

    def get_password
      # get the password
    end
  
    def noncompliant
      username = params[:username]
  
      begin

        conn = PG.connect(
            dbname: get_db,
            user: get_username,
            password: get_password,
            host: 'localhost'
          )

        # Noncompliant: Direct concatenation of user input into the SQL query string, without proper sanitization or parameterization.
        result = conn.exec_params('SELECT * FROM users WHERE username = ' + username)
  
      ensure
        # Ensure the connection is closed
        conn.close if conn
      end
    end
end
# {/fact}