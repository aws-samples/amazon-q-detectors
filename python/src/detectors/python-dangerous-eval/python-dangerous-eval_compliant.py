#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-dangerous-eval@v1.0 defects=0}
import ast

def conformant():
    with open('file.txt') as f:
        command = f.read()
    # Compliant: Use `ast.literal_eval` instead of `eval`.
    ast.literal_eval(command)
# {/fact}
