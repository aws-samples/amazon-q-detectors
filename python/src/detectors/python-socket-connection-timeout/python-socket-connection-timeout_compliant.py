#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-socket-connection-timeout@v1.0 defects=0}
import socket

def conformant_case(sampleHost, samplePort, sampleBufferSize):
    s = None
    try:
        # Compliant: Socket timeout is set.
        s = socket.create_connection((sampleHost, samplePort), timeout=10)
        print(s.recv(sampleBufferSize))
    finally:
        if s:
            s.close()
# {/fact}
