# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-efficient-concatenation-of-immutable-objects@v1.0 defects=0}
def compliant():
    sampleList = ['sampleString1', 'sampleString2', 'sampleString3']
    concatenatedString = []
    for item in sampleList:
        # Compliant: Appending values to a list and concatenating that list using `.join()` method.
        concatenatedString.append(item + "\n")
    return ''.join(concatenatedString)
# {/fact}
