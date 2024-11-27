#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-hashlib-naive-hashing-not-suitable-for-secrets@v1.0 defects=0}
from argon2 import PasswordHasher

def compliant(api_key):
    # Compliant: More secure hash function is being used.
    ph = PasswordHasher()
    hash = ph.hash(api_key)
    return hash
# {/fact}
