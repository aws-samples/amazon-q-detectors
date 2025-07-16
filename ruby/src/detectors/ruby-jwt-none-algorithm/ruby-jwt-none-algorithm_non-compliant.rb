# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-jwt-none-algorithm@v1.0 defects=1}
require 'jwt'

class TokenController < ApplicationController
  def noncompliant
    payload = { user_id: 123, exp: Time.now.to_i + 3600 }
    # Noncompliant: Using `none` algorithm makes JWT tokens unsigned and vulnerable to tampering.
    token = JWT.encode(payload, nil, 'none')
    render json: { token: token }
  end
end
# {/fact}
