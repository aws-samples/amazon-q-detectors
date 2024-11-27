#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-always-verify-the-ssl-certificates@v1.0 defects=1}
import requests

def non_compliant():
    # Noncompliant: When `verify` is set to `False`, requests will accept any TLS certificate presented by the server.
    response = requests.head('https://example.com/api/user', verify=False)
    return response

# {/fact}
