#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-jwt-none-algorithm@v1.0 defects=1}
import jwt

def non_compliant():
    # Noncompliant: Using `none` as the algorithm in `jwt.encode()` is insecure and leaves the JWT token unsigned.
    encoded = jwt.encode({'msg': 'some text'}, None, algorithm='none')
    return encoded
# {/fact}
