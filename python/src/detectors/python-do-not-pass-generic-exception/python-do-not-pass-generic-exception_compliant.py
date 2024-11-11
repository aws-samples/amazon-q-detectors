#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-pass-generic-exception@v1.0 defects=0}
def error_handling_compliant():
    number = input("Enter number:\n")
    try:
        int(number)
    except ValueError:
        # Compliant: Has proper error handling.
        print(number, "is not an integer.")
# {/fact}
