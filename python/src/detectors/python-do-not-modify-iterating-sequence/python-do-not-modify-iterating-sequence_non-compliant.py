# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-modify-iterating-sequence@v1.0 defects=1}
def non_compliant():
    words = ['cat', 'window', 'defenestrate']
    # Noncompliant: Modifies the same list while iterating over it.
    for word in words:
        if len(word) > 6:
            words.insert(0, word)
# {/fact}
