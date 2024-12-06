# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-modify-iterating-sequence@v1.0 defects=0}
def compliant():
    words = ['cat', 'window', 'defenestrate']
    # Compliant: Made a copy before modifying the sequence.
    for word in words[:]:
        if len(word) > 6:
            words.insert(0, word)
# {/fact}
