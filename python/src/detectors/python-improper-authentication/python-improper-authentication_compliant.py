#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-improper-authentication@v1.0 defects=0}
import jwt

def improper_authentication_compliant(token):
    # Compliant: Verified the JWT token.
    jwt.decode(token, verify=True)
# {/fact}
