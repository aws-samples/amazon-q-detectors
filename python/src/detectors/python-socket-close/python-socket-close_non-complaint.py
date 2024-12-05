#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-socket-close@v1.0 defects=1}
def non_conformant_case(sampleHost, samplePort, sampleBufferSize):
    import socket
    socket = socket.socket()
    socket.settimeout(20)
    socket.connect((sampleHost, samplePort))
    print(socket.recv(sampleBufferSize))
    # Noncompliant: `socket.shutdown` is not called before closing the socket.
    socket.close()
# {/fact}
