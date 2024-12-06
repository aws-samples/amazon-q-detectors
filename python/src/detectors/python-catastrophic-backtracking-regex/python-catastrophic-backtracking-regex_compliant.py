#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-catastrophic-backtracking-regex@v1.0 defects=0}
import regex

def compliant():
    input = 'input string'
    replacement = 'replacement'
    # Compliant: Safe, efficient string substitution.
    regex.subf('xx+y', replacement, input)
# {/fact}
