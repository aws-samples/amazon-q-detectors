#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-tls-ciphers-with-known-security-issues@v1.0 defects=1}
import ssl

def non_compliant():
    context = ssl.create_default_context()
    # Noncompliant:  The TLS cipher suite is set to an insecure cipher suite which provides poor authentication.
    context.set_ciphers("TLS_DH_anon_WITH_AES_256_GCM_SHA384")

# {/fact}
