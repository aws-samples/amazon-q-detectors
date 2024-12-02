#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pickle-insecure-deserialization@v1.0 defects=0}
import pickle
import requests

def positive_dumps_loads():
    data = bytes(requests.get("https://data.bytes"))
    tmp = pickle.dumps(data)
    # Compliant: Safely serializes and deserializes byte data using pickle methods.
    pickle.loads(tmp)
# {/fact}
