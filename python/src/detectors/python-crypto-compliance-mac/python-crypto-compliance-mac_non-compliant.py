#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compliance-mac@v1.0 defects=1}
from cryptography.hazmat.primitives import hashes, hmac

def cryptography_non_conformant():
    key = b"myencryptionkey"
    # Noncompliant: Uses a weak hashing algorithm (SHA1) for HMAC, which is vulnerable to attacks and should not be used.
    h = hmac.HMAC(key, algorithm=hashes.SHA1())
    return h
# {/fact}
