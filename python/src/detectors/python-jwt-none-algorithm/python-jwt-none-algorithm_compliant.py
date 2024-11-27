#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-jwt-none-algorithm@v1.0 defects=0}
import jwt

def compliant(secret_key):
    # Compliant: Proper algorithm `HS256` is used for encoding the JWT token.
    encoded = jwt.encode({'msg': 'some text'}, secret_key, algorithm='HS256')
    return encoded
# {/fact}
