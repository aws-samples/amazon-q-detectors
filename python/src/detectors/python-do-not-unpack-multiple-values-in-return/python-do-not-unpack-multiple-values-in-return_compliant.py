# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-unpack-multiple-values-in-return@v1.0 defects=0}
from collections import namedtuple

def compliant():
    # Compliant: Returning a `namedtuple` instance instead.
    Result = namedtuple('Result', ['char', 'string', 'number', 'list'])
    return Result('a', 'abc', 100, [0, 1, 2])
# {/fact}
