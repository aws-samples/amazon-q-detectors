#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-key-generator@v1.0 defects=0}
from cryptography.hazmat.primitives import hashes, hmac
import secrets

def cryptography_compliant():
    # Compliant: Key size is sufficient for encryption algorithm.
    key = secrets.token_bytes(48)
    hash_key = hmac.HMAC(key, algorithm=hashes.SHA512_224())
# {/fact}
