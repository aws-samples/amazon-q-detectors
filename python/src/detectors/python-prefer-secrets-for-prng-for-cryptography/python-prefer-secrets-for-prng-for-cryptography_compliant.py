#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prefer-secrets-for-prng-for-cryptography@v1.0 defects=0}
import secrets
import hashlib

def conformant_case():
    salt = secrets.token_bytes()
    hash_str = hashlib.sha256()
    # Compliant: `secrets` module is used for generating cryptographically strong random numbers.
    hash_str.update(salt)
# {/fact}
