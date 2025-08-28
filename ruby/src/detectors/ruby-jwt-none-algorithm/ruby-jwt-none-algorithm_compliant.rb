# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-jwt-none-algorithm@v1.0 defects=0}
require 'jwt'

class TokenController < ApplicationController
  def compliant
    payload = { user_id: 123, exp: Time.now.to_i + 3600 }
    secret_key = ENV['JWT_SECRET_KEY']
    # Compliant: Using a secure algorithm `HS256` with a secret key to sign JWT tokens.
    token = JWT.encode(payload, secret_key, 'HS256')
    render json: { token: token }
  end
end
# {/fact}
