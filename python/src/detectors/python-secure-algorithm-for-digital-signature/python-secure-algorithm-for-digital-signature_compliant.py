#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-algorithm-for-digital-signature@v1.0 defects=0}
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import hashes

def sign_verify_with_secure_algo_compliant():
    private_key = ec.generate_private_key(
        ec.SECP384R1()
    )
    data = b"this is some data I'd like to sign"
    # Compliant: Uses the secure `SHA256` hash algorithm for signing data
    signature = private_key.sign(
        data,
        ec.ECDSA(hashes.SHA256())
    )
    return signature
# {/fact}
