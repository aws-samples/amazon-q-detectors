#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-error-prone-multidimensional-list-init@v1.0 defects=0}
def error_prone_multidimensional_list_conformant():
    # Compliant: `list` initialized with a single bracket.
    a = [[1] * 3, [9] * 4]
    return a
# {/fact}
