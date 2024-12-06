# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-try-except-pass@v1.0 defects=0}
import os
import logging

def compliant():
    server_addr = 'uds.socket'
    try:
        os.remove(server_addr)
    # Compliant: Proper error handling can prevent attacks and unwanted behavior.
    except Exception as e:
        logging.exception("Include relevant information about the exception here", e, stack_info=True, exc_info=True)
# {/fact}
