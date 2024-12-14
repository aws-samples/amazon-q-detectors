#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-always-verify-the-ssl-certificates@v1.0 defects=0}
import requests

def compliant():
    # Compliant: When `verify` is set to `true`, requests will not accept any TLS certificate presented by the server.
    response = requests.head('https://example.com/api/user', verify=True)
    return response

# {/fact}
