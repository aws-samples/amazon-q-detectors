# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-hashlib-named-constructor-usage@v1.0 defects=0}
import hashlib

def compliant():
    text = "Compliant"
    # Noncompliant: Using the `hashlib.sha256()`, which is faster.
    result = hashlib.sha256(text.encode())
    print("The hexadecimal equivalent of SHA256 is : ")
    print(result.hexdigest())
# {/fact}
