#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-all-interfaces-socket-binding@v1.0 defects=0}
import socket

def insecure_socket_bind_compliant():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # Compliant: Non-empty IP Address is passed when binding to a socket.
    s.bind(('192.168.1.1', 0))
# {/fact}
