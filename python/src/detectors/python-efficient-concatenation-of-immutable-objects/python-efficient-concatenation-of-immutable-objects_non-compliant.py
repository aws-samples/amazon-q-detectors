# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-efficient-concatenation-of-immutable-objects@v1.0 defects=1}
def non_compliant():
    sampleList = ['sampleString1', 'sampleString2', 'sampleString3']
    concatenatedString = ''
    for item in sampleList:
        # Noncompliant: Inefficient string concatenation inside a loop is used.
        concatenatedString += item + "\n"
    return concatenatedString
# {/fact}
