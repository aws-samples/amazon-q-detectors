#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-jwt-exposed-credentials-or-hardcoded-secret@v1.0 defects=0}
import os
import jwt

def compliant(secret, value, hdr):
    secret = os.getenv('JWT_SECRET_KEY')
    if not secret:
        raise ValueError("JWT secret key not configured")
    # Compliant: Dynamically generated or securely stored JWT secret is being used
    return jwt.encode({'key': 'payload', 'password': value}, secret, algorithm='ES256', headers=hdr)
# {/fact}
