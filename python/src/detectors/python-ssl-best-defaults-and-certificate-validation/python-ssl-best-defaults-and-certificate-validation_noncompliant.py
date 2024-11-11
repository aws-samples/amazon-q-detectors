#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ssl-best-defaults-and-certificate-validation@v1.0 defects=1}
import socket
import ssl

def create_connection_noncompliant():
    host, port = 'example.com', 443
    with socket.socket(socket.AF_INET) as sock:
        context = ssl.SSLContext()
        # Noncompliant: Security certificate validation disabled.
        context.verify_mode = ssl.CERT_NONE
        conn = context.wrap_socket(sock, server_hostname=host)
        try:
            conn.connect((host, port))
            handle(conn)
        finally:
            conn.close()
# {/fact}
