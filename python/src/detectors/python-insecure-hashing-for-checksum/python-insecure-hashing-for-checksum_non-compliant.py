#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-hashing-for-checksum@v1.0 defects=1}
import hashlib
import tempfile

def non_compliant():
    with open("filename.png", "rb") as f:
        # Noncompliant: Using `md5` algorithm is considered insecure for generating file checksum.
        file_hash = hashlib.md5()
        while chunk := f.read(8192):
            file_hash.update(chunk)
    return file_hash.digest()
# {/fact}
