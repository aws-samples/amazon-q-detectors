#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-tls-ciphers-with-known-security-issues@v1.0 defects=0}
import ssl

def compliant():
    context = ssl.create_default_context()
    # Compliant: The TLS cipher provides proper authentication.
    print(context.get_ciphers())

# {/fact}
