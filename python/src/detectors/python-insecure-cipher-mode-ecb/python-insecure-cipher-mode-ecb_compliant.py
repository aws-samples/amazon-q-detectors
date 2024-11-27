#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-cipher-mode-ecb@v1.0 defects=0}
from cryptography.hazmat.primitives.ciphers.modes import CBC
from cryptography.hazmat.primitives.ciphers import Cipher
from cryptography.hazmat.primitives.ciphers import algorithms

def compliant():
    # Compliant: `CBC` mode is secure.
    cipher = Cipher(algorithms.AES(key), CBC())
    encryptor = cipher.encryptor()
# {/fact}
