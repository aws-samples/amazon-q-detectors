#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-hashing-for-checksum@v1.0 defects=0}
import hashlib
import tempfile

def file_checksum_compliant5(stream, checksum=None):
    # Compliant: Using `SHA-384` is considered secure.
    sha384 = hashlib.sha384()
    with tempfile.TemporaryFile() as temp:
        while True:
            data = stream.read(8192)
            if not data:
                break
            sha384.update(data)
            temp.write(data)
        temp.seek(0)
        sha384 = sha384.digest()
    return sha384
# {/fact}
