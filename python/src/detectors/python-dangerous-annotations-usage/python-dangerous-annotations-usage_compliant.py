#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-annotations-usage@v1.0 defects=0}

def example_function(a):
    pass

def compliant():
    func = example_function
    # Compliant: Set the type statically, or set type dynamically only if you trust the type.
    func.__annotations__['a'] = int
    return func
# {/fact}
