# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-hashlib-named-constructor-usage@v1.0 defects=1}
import hashlib

def non_compliant():
    text = "Noncompliant"
    # Noncompliant: Using the `new()` constructor, which is slower.
    result = hashlib.new('sha256', text.encode())
    print("The hexadecimal equivalent of SHA256 is : ")
    print(result.hexdigest())
# {/fact}
