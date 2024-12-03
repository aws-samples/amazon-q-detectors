# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-try-except-pass@v1.0 defects=1}
import os

def non_compliant():
    server_addr = 'uds.socket'
    try:
        os.remove(server_addr)
    # Noncompliant: Improper error handling can enable attacks and lead to unwanted behavior.
    except:
        pass
# {/fact}
