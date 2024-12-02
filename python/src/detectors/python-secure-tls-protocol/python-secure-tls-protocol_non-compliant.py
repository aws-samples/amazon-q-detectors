#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-tls-protocol@v1.0 defects=1}
import ssl

def non_compliant():
    # Noncompliant: Uses the insecure and outdated `SSLv2` protocol, which is vulnerable to various attacks.
    context = ssl.SSLContext(ssl.PROTOCOL_SSLv2)
    return context
# {/fact}
