#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-weak-password-encoder@v1.0 defects=1}
PASSWORD_HASHERS = [
    # Noncompliant: Uses non-standard or insecure password hashers.
    "django.contrib.auth.hashers.MD5PasswordHasher",
    "django.contrib.auth.hashers.PBKDF2PasswordHasher"
]
# {/fact}
