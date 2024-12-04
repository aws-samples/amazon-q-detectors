#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unnecessary-iteration@v1.0 defects=1}
def nonconformant_list():
    data = set(["sampleString1", "sampleString2", "sampleString3"])
    for i in data:
        # Noncompliant: A loop is used to access access a single item.
        if i == "sampleString1":
            print("found item")
# {/fact}
