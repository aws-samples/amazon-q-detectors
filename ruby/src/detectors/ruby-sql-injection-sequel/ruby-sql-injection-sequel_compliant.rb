# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
             
# {fact rule=ruby-sql-injection-sequel@v1.0 defects=0}
require 'sequel'

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
  
  
    def compliant 
      username = "saveduser" 
  
      db = Sequel.connect('postgres://user:#{get_password}@localhost/#{get_db}')

      # Compliant: Query has not been constructed from external input and proper parameterization has been followed.
      user = db['SELECT * FROM users WHERE username = ?', username].first
  
    end
end
# {/fact}
