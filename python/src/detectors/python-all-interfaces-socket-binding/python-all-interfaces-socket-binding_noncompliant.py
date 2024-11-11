#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-all-interfaces-socket-binding@v1.0 defects=1}
import socket

def insecure_socket_bind_noncompliant():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # Noncompliant: Empty IP Address is passed when binding to a socket.
    s.bind(('', 0))
# {/fact}
