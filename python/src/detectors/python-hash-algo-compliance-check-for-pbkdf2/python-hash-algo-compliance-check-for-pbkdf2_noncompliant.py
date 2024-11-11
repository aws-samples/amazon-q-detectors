#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=1}
import hashlib
from hashlib import pbkdf2_hmac

def hashing_noncompliant(password, salt):
    # Noncompliant: Insecure hashing algorithm is used.
    derivedkey = hashlib.pbkdf2_hmac('sha224', password, salt, 100000)
    derivedkey.hex()
# {/fact}
