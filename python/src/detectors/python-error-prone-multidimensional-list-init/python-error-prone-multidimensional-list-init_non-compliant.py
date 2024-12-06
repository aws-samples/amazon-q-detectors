#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-error-prone-multidimensional-list-init@v1.0 defects=1}
def error_prone_multidimensional_list_non_conformant():
    # Noncompliant: `list` initialized with multiple brackets.
    multi_dim_list = [[[1] * 2] * 2]
    return multi_dim_list
# {/fact}
