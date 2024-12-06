# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-break-continue-return-in-finally@v1.0 defects=1}
def non_compliant():
    for i in range(10):
        try:
            raise ValueError()
        finally:
            # Noncompliant: Using `continue`, `break`, or `return` in a finally block will mask unhandled exceptions.
            continue
# {/fact}
