#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-equality-vs-identity@v1.0 defects=0}
from sys import intern

def conformant_is_operator():
    greeting = "It's a beautiful day in the neighbourhood."
    a = intern(greeting)
    # Compliant: Use the `is` operator to check if two variables refer to the same object.
    if a is None:
        return True
# {/fact}
