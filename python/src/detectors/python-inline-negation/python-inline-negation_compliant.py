#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-inline-negation@v1.0 defects=0}
def conformant():
    a = 5
    b = 10
    # Compliant: Follows the `PEP8` programming recommendations, improving readability.
    if a != b:
        print(a)
# {/fact}
