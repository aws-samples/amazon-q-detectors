#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unnecessary-iteration@v1.0 defects=0}
def conformant_list():
    data = set(["sampleString1", "sampleString2", "sampleString3"])
    # Compliant: A loop is not used to access a single item.
    if "sampleString1" in data:
        print("found item")
# {/fact}
