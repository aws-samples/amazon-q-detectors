#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-cipher-mode-ecb@v1.0 defects=1}
import os
from cryptography.hazmat.primitives.ciphers import Cipher
from cryptography.hazmat.primitives.ciphers import algorithms
from cryptography.hazmat.primitives.ciphers.modes import ECB

def non_compliant():
    key = os.urandom(32)
    iv = os.urandom(16)
    # Noncompliant: `ECB` mode is used for cipher creation.
    cipher = Cipher(algorithms.AES(key), ECB(iv))
# {/fact}
