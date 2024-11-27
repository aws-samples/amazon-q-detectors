#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-annotations-usage@v1.0 defects=1}
from typing import get_type_hints

def example_function(a):
    pass

def non_compliant(some_type):
    func = example_function
    # Noncompliant: Sets the type annotation dynamically using an arbitrary value, potentially leading to the invocation of arbitrary code, which poses a security risk.
    func.__annotations__['b'] = some_type
    get_type_hints(func)
    return func
# {/fact}
