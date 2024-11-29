#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-multiprocessing-connection-recv@v1.0 defects=0}
from multiprocessing.connection import Listener

def compliant(authkey, bytes_data, address, family = 'AF_INET', backlog = 1):
    # Compliant: Uses Authtoken for sending data in `byte_stream`.
    listener = Listener(address,family,backlog,authkey=authkey)
    conn = listener.accept()
    conn.send_bytes(bytes_data)
# {/fact}
