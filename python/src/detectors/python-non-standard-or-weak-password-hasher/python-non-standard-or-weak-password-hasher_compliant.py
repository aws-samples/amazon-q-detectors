#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-standard-or-weak-password-hasher@v1.0 defects=0}
from django.contrib.auth.hashers import PBKDF2PasswordHasher

# Compliant: Inherits from a secure, modern `PBKDF2` password hashing algorithm.
class MyPBKDF2PasswordHasher(PBKDF2PasswordHasher):
    pass
# {/fact}
