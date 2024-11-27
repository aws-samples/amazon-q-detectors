#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-detect-pbkdf-hardcoded-password@v1.0 defects=0}
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend
from cryptography.fernet import Fernet
import base64
import os
from flask import app

@app.route("/login/otp", methods=["POST"])
def crypto_compliant():
    salt = os.urandom(32)
    ENCRYPTION_KEY = app.secret_key.encode('utf-8')
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=310000, 
        backend=default_backend()
    )
    # Compliant: App secret key is used as the key material for `PBKDF2` derivation, avoiding hardcoded values.
    key = base64.urlsafe_b64encode(kdf.derive(ENCRYPTION_KEY))
    f = Fernet(key)
    return f
# {/fact}
