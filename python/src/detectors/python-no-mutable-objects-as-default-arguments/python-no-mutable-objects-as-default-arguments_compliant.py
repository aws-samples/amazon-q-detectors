#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-no-mutable-objects-as-default-arguments@v1.0 defects=0}
# Compliant: Uses `None` as default argument and initializes mutable object inside function.
def compliant(itemName, itemList=None):
    if itemList is None:
        itemList = []
    itemList.append(itemName)
    return itemList
# {/fact}
