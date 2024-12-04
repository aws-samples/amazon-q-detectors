#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compliance-cipher@v1.0 defects=1}
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
import os

def cryptography_AES_cipher_noncompliant():
    key = os.urandom(32)
    iv = os.urandom(16)
    # Noncompliant: Insecure use of `AES` in `ECB` mode, which is vulnerable to attacks and should not be used.
    cipher = Cipher(algorithms.AES(key), modes.ECB(iv))
    encryptor = cipher.encryptor()
    ct = encryptor.update(b"a secret message") + encryptor.finalize()
    decryptor = cipher.decryptor()
    decryptor.update(ct) + decryptor.finalize()
# {/fact}
