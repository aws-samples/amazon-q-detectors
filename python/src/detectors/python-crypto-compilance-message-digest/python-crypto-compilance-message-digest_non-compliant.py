#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compilance-message-digest@v1.0 defects=1}
import hashlib

def non_compliant():
    # Noncompliant: The hashing algorithm used here is unsecure and might lead to cryptographic vulnerabilities.
    m = hashlib.md5()
    m.update(b"CodeGuru")
    m.digest()
# {/fact}
