#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-find-substring@v1.0 defects=1}
def find_nonconformant():
    # Noncompliant: Compares the result of `find()` with -1 to determine presence, which is redundant and less readable.
    if "CodeGuru".find("Python") == -1:
        print("String not found")
    else:
        print("String found")
# {/fact}
