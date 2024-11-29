 #  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-tls-protocol@v1.0 defects=0}
import ssl

def compliant():
    # Compliant: Uses the secure TLS protocol for SSL/TLS communication
    context = ssl.SSLContext(ssl.PROTOCOL_TLS)
    return context
# {/fact}
