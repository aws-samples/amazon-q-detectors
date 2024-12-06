#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-eval@v1.0 defects=1}
def non_conformant():
    with open('file.txt') as f:
        command = f.read()
    # Noncompliant: `eval()` function is used with user input, which can lead to arbitrary code execution.
    eval(command)
# {/fact}
