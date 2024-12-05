#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-socket-close@v1.0 defects=0}
import socket

def conformant_case(sampleHost, samplePort, sampleBufferSize):
    socket = socket.socket()
    socket.connect((sampleHost, samplePort))
    print(socket.recv(sampleBufferSize))
    # Compliant: `socket.shutdown` is called before closing the socket.
    socket.shutdown(socket.SHUT_WR)
    socket.close()
# {/fact}
