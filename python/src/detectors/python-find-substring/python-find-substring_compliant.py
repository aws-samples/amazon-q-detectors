#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-find-substring@v1.0 defects=0}
def find_conformant():
    # Compliant: Directly returns the starting index of the substring, or -1 if not found, without unnecessary checks.
    return "CodeGuru".find("Guru")
# {/fact}
