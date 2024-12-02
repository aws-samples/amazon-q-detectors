#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-pickle-insecure-deserialization@v1.0 defects=1}
import pickle
import requests

def negative_loads_request():
    data = bytes(requests.get("https://data.bytes"))
    # Noncompliant: Directly uses `pickle.loads()` on untrusted request data, exposing critical security risks.
    pickle.loads(data)
# {/fact}
