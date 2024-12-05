#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-use-dictionary-get-with-default-value@v1.0 defects=0}
import os

def get_paperwork_api_endpoint_safe():
    # Compliant: Uses `.get()` with a default value which safely handles missing dictionary keys
    _endpoint: str = f"https://{os.environ.get('PAPERWORK_API_ADDRESS', 'default_address')}"
    return _endpoint
# {/fact}
