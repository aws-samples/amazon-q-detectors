#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=0}
import hashlib
from hashlib import pbkdf2_hmac

def hashing_compliant(password, salt):
    # Compliant: Secure hashing algorithm is used.
    derivedkey = hashlib.pbkdf2_hmac('sha256', password, salt, 100000)
    derivedkey.hex()
# {/fact}
