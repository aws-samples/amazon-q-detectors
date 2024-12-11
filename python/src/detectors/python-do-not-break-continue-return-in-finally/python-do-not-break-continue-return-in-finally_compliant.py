# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-break-continue-return-in-finally@v1.0 defects=0}
def compliant():
    for i in range(10):
        try:
            raise ValueError()
        except ValueError:
            pass
        finally:
            # Noncompliant: Using `continue`, `break`, or `return` is avoided.
            pass
# {/fact}
