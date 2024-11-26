#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-always-verify-the-ssl-certificates@v1.0 defects=0}
import requests

def compliant():
    # Compliant: Explicitly setting `verify` to `True` to ensure SSL verification.
    response = requests.head('https://example.com/api/user', verify=True)
    return response

# {/fact}
