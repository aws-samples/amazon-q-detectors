#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-secure-algorithm-for-digital-signature@v1.0 defects=1}
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import hashes

def sign_verify_with_secure_algo_noncompliant():
    private_key = ec.generate_private_key(
        ec.SECP384R1()
    )
    data = b"this is some data I'd like to sign"
    # Noncompliant: Uses the weaker `SHA224` hash algorithm, which is not recommended for cryptographic purposes.
    signature = private_key.sign(
        data,
        ec.ECDSA(hashes.SHA224())
    )
    return signature
# {/fact}
