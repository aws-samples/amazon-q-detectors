#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-handle-missing-dict-key@v1.0 defects=0}
def conformant_case():
    mydict = {1: 1, 2: 2, 3: 3}
    item = 5
    # Compliant: Using `mydict.get()` method efficiently handles missing keys with a default value.
    return mydict.get(item, 0)
# {/fact}
