#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-handle-missing-dict-key@v1.0 defects=1}
def keyerror_nonconformant_case1():
    mydict = {1: 1, 2: 2, 3: 3}
    key = 5
    try:
        count = mydict[key]
    # Noncompliant: Use `mydict.get()` instead of try-except for handling missing dictionary keys.
    except KeyError:
        count = 0
    return count
# {/fact}
