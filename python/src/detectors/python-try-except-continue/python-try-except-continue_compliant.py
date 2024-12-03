# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-try-except-continue@v1.0 defects=0}
from common.socket import SocketException
import logging

def compliant(self, client):
    while True:
        try:
            endpoint = client.recv()
        except SocketException as e:
            break
        # Compliant: Proper error handling can prevent attacks and unwanted behavior.
        except Exception as e:
            logging.exception(e)
            continue
# {/fact}
