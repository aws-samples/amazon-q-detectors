#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-pass-generic-exception@v1.0 defects=1}
def error_handling_pass_noncompliant():
    number = input("Enter number:\n")
    try:
        int(number)
    except Exception:
        # Noncompliant: Has improper error handling.
        pass
# {/fact}
