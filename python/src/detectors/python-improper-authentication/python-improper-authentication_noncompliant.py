#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-improper-authentication@v1.0 defects=1}
import jwt

def improper_authentication_noncompliant(token):
    # Noncompliant: JWT token not verified.
    jwt.decode(token, verify=False)
# {/fact}
