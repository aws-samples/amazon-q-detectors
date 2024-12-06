# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-expect-and-raise-exception@v1.0 defects=1}
def non_compliant():
    try:
        print("Some Operation...")
    # Noncompliant: Catching and re-throwing an exception without performing any additional operations is redundant and reduces performance.
    except KeyError:
        raise
# {/fact}
