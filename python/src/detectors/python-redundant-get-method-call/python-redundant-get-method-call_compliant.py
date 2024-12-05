#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-redundant-get-method-call@v1.0 defects=0}
def conformant_case():
    dict = {"A":1, "B":2}
    # Compliant: Uses `.get()` with a meaningful default value.
    val = dict.get("C", "Not found!")
    return val
# {/fact}
