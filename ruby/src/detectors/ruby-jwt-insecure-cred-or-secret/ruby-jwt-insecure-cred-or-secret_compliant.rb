# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-jwt-insecure-cred-or-secret@v1.0 defects=0}
require 'jwt'

def compliant(hmac_secret)
    # Compliant: No sensitive data is being passed.
    nbf = Time.now.to_i + 60 
    payload = {data: 'data', nbf: nbf}
    token = JWT.encode payload, hmac_secret, 'HS256'
end
# {/fact}
