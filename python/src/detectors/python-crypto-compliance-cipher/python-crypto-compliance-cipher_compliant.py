#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compliance-cipher@v1.0 defects=0}
from cryptography.hazmat.primitives.ciphers.aead import ChaCha20Poly1305
import os

def cryptography_ChaCha20Poly1305_cipher_compliant():
    data = b"a secret message"
    aad = b"authenticated but unencrypted data"
    # Complaint: Secure use of `ChaCha20Poly1305` `AEAD` cipher with proper key generation and nonce handling.
    key = ChaCha20Poly1305.generate_key()
    chacha = ChaCha20Poly1305(key)
    nonce = os.urandom(12)
    ct = chacha.encrypt(nonce, data, aad)
    chacha.decrypt(nonce, ct, aad)
# {/fact}
