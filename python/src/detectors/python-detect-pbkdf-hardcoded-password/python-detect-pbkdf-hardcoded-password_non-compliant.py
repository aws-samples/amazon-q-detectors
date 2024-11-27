#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-pbkdf-hardcoded-password@v1.0 defects=1}
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import os
from cryptography.hazmat.primitives import hashes

def crypto_non_compliant():
    salt = os.urandom(32)  
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=100000
    )
    # Noncompliant: A hardcoded password `my super password` is used as the key material for `PBKDF2` derivation, which is a security risk.
    key = kdf.derive(key_material = b"my super password")
    return key
# {/fact}
