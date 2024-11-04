# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-jwt-insecure-cred-or-secret@v1.0 defects=1}
require 'jwt'

def noncompliant(hmac_secret)
    # Noncompliant: User 'password', which is sensitive data being passed in the 'JWT'.
    payload = { data: 'data', password: 12345 }
    token = JWT.encode payload, hmac_secret, 'HS256'
end
# {/fact}
