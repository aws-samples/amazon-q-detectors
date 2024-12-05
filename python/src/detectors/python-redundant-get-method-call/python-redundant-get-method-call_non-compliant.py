#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-redundant-get-method-call@v1.0 defects=1}
def nonconformant_case():
    dict = {"A":1, "B":2}
    # Noncompliant: Uses `.get()` with `None` which is redundant since `.get()` already returns `None` by default when the key is not found.
    val = dict.get("C", None)
    return val
# {/fact}
