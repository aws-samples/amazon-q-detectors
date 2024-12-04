#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-use-dictionary-get-with-default-value@v1.0 defects=1}
import os

def get_paperwork_api_endpoint_unsafe():
    # Noncompliant: Uses direct dictionary access `[]` which will raise a KeyError if the key doesn't exist.
    _endpoint: str = f"https://{os.environ['PAPERWORK_API_ADDRESS']}"
    return _endpoint
# {/fact}
