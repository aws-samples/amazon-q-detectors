#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prefer-secrets-for-prng-for-cryptography@v1.0 defects=1}
import random
import hashlib

def non_conformant_case():
    complex_str = "abcdefghijklmnopqrstuvwkyz123456789!@#$%^&*()"
    salt = random.choice(complex_str).encode()
    hash_str = hashlib.sha256()
    # Noncompliant: `random` module is used for generating pseudo-random numbers, which is not suitable for cryptographic purposes.
    hash_str.update(salt)
# {/fact}
