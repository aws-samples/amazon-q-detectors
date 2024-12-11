#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-no-mutable-objects-as-default-arguments@v1.0 defects=1}
# Noncompliant: Uses mutable objects (dict and list) as default arguments.
def non_compliant(index=1, mydict={}, mylist=[]):
    mydict[index] = mylist[index]
    return mydict
# {/fact}
