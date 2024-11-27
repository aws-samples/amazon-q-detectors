#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-hashlib-naive-hashing-not-suitable-for-secrets@v1.0 defects=1}
import hashlib, uuid

def noncompliant():
    salt = uuid.uuid4().hex
    # Noncompliant: Less secure hash function is being used.
    password = hashlib.sha512(password + salt).hexdigest()
# {/fact}
