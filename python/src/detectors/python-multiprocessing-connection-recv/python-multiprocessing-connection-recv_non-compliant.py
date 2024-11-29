#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-multiprocessing-connection-recv@v1.0 defects=1}
from multiprocessing.connection import Listener

def non_compliant(bytes_data):
    # Noncompliant: No authentication is used for sending data.
    listener = Listener()
    conn = listener.accept()
    conn.send_bytes(bytes_data)
# {/fact}
