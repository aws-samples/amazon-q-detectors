#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-socket-connection-timeout@v1.0 defects=1}
import socket

def non_conformant_case(sampleHost, samplePort, sampleBufferSize):
    # Noncompliant: Socket timeout is not set.
    s = socket.create_connection((sampleHost, samplePort))
    print(s.recv(sampleBufferSize))
    s.close()
# {/fact}
