#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-equality-vs-identity@v1.0 defects=1}
def nonconformant_eq_operator():
    a = ''
    # Noncompliant: Use 'is' instead of '=='.
    if a == None:
        print("a eq None")
# {/fact}
