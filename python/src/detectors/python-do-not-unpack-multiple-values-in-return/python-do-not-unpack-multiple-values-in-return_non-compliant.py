# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-unpack-multiple-values-in-return@v1.0 defects=1}
def non_compliant():
    # Noncompliant: Using a large number of return values making it prone to errors.
    return 'a', 'abc', 100, [0, 1, 2]
# {/fact}
