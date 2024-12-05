#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-inline-negation@v1.0 defects=1}
def non_conformant():
    a = 5
    b = 10
    # Noncompliant: Violates `PEP8` programming recommendations, making it difficult to read.
    if not a is b:
        print(a)
# {/fact}
