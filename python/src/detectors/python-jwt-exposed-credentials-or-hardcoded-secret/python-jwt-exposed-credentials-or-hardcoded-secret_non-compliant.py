#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-jwt-exposed-credentials-or-hardcoded-secret@v1.0 defects=1}
import jwt

def non_compliant(secret, value, hdr):
    # Noncompliant: Hardcoded JWT secret (private key) is being used
    encoded = jwt.encode({'key': 'payload', 'password': value}, secret, algorithm='ES256', headers=hdr)
    return encoded
# {/fact}
