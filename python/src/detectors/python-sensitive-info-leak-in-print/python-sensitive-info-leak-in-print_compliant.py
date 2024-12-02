#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sensitive-info-leak-in-print@v1.0 defects=0}
from argon2 import PasswordHasher
import binascii
import os

def conformant(request):
    password = request.form['password']
    salt = os.urandom(16)
    hash = PasswordHasher().hash(password.encode('utf-8')).encode()
    password = binascii.hexlify(hash).decode() + salt.hex()
    # Compliant: The code follows best practices by protecting sensitive information from being leaked.
    print("Password encrypted successfully !!")
# {/fact}
