#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-insecure-iv@v1.0 defects=0}
import os
import uuid
from Crypto.Cipher import AES

def compliant():
    key = os.urandom(32)
    # Compliant: `iv` is not hardcoded.
    iv = uuid.uuid4()
    cipher = AES.new(key, AES.MODE_GCM, iv)
    encryptor = cipher.encryptor()
    ct = encryptor.update(b"a secret message") + encryptor.finalize()
    decryptor = cipher.decryptor()
    decryptor.update(ct) + decryptor.finalize()
# {/fact}
