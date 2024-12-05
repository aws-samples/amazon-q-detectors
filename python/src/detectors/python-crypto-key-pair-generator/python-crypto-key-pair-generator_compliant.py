#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-key-pair-generator@v1.0 defects=0}
from cryptography.hazmat.primitives.asymmetric import dh

def conformant():
    # Compliant: Key size is sufficient for DH algorithm.
    parameters = dh.generate_parameters(generator=2, key_size=2048)
    server_private_key = parameters.generate_private_key()
    return server_private_key
# {/fact}
