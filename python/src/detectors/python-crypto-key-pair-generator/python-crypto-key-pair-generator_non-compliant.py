#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-key-pair-generator@v1.0 defects=1}
from cryptography.hazmat.primitives.asymmetric import rsa

def non_conformant():
   # Noncompliant: Key size is too small for RSA algorithm.
   private_key = rsa.generate_private_key(key_size=1024,public_exponent=65537)
   public_key = private_key.public_key()
   return public_key
# {/fact}
