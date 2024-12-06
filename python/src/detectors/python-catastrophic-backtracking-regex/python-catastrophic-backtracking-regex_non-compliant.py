#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-catastrophic-backtracking-regex@v1.0 defects=1}
import regex

def non_compliant():
    input = 'input string'
    replacement = 'replacement'
    # Noncompliant: Risks catastrophic backtracking, performance issues.
    regex.subfn('(a*)*b', replacement, input)
# {/fact}
