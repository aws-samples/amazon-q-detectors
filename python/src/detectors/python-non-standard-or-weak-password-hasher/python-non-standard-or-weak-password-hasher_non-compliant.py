#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-standard-or-weak-password-hasher@v1.0 defects=1}
from django.contrib.auth import hashers

# Noncompliant: Uses the deprecated, cryptographically weak `SHA1` hashing algorithm vulnerable to rainbow table attacks.
class MySHA1PasswordHasher(hashers.SHA1PasswordHasher):
    pass
# {/fact}
