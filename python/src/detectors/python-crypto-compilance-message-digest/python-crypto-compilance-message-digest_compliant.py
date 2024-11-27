#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compilance-message-digest@v1.0 defects=0}
import hashlib

def compliant():
    # Compliant: Use a more secure hashing algorithm when creating message digests using hashlib.
    h = hashlib.blake2b()
    h.update(b'Hello world')
    h.hexdigest()
# {/fact}
