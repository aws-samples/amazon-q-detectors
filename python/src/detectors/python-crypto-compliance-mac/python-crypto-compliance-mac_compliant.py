#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-compliance-mac@v1.0 defects=0}
from cryptography.hazmat.primitives import hashes, hmac

def cryptography_compliant():
    key = b"myencryptionkey"
    # Compliant: Use strong algorithm such as `SHA224`, `SHA256`, `SHA384`, `SHA512/224`, or `SHA512/256`.
    h = hmac.HMAC(key, algorithm=hashes.SHA512_224())
    return h
# {/fact}
