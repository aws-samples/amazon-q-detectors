# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-try-except-continue@v1.0 defects=1}
from common.socket import SocketException

def non_compliant(self, client):
    while True:
        try:
            endpoint = client.recv()
        except SocketException as e:
            break
        # Noncompliant: Improper error handling can enable attacks and lead to unwanted behavior.
        except:
            continue
# {/fact}
