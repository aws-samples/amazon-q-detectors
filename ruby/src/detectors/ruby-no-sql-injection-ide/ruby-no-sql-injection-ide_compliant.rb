# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-no-sql-injection-ide@v1.0 defects=0}
require 'mongo'

def compliant
  username = params[:username]
  password = params[:password]
  
  client = Mongo::Client.new(['127.0.0.1:27017'], database: 'myapp')
  users = client[:users]
  
  # Compliant: Using `BSON::Document` to safely structure MongoDB queries.
  user = users.find({"username" => BSON::Document.new(username: username), 
                     "password" => BSON::Document.new(password: password)}).first
  
  if user
    session[:user_id] = user['_id'].to_s
    redirect '/dashboard'
  else
    "Invalid credentials"
  end
end
# {/fact}
