# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-no-sql-injection-ide@v1.0 defects=1}
require 'mongo'

def noncompliant
  username = params[:username]
  password = params[:password]
  
  client = Mongo::Client.new(['127.0.0.1:27017'], database: 'myapp')
  users = client[:users]
  
  # Noncompliant: Using user input directly in MongoDB queries can lead to NoSQL injection attacks.
  user = users.find({"username" => username, "password" => password}).first
  
  if user
    session[:user_id] = user['_id'].to_s
    redirect '/dashboard'
  else
    "Invalid credentials"
  end
end
# {/fact}
