#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-crypto-insecure-iv@v1.0 defects=1}
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes

def non_compliant():
    data = b'Unaligned' 
    key = get_random_bytes(32)
    # Noncompliant: `iv` is hardcoded, which is insecure.
    iv = "1234567812345678"
    cipher1 = AES.new(key, AES.MODE_GCM, iv)
    ct = cipher1.encrypt(pad(data, 16))
    cipher2 = AES.new(key, AES.MODE_ECB, iv)
    pt = unpad(cipher2.decrypt(ct), 16)
    assert(data == pt)
# {/fact}
