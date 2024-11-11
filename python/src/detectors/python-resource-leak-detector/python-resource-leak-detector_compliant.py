#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-resource-leak-detector@v1.0 defects=0}
def read_file_compliant(filename):
    # Compliant: File is processed using `with` statement.
    with open(filename, 'r') as f:
        return f.readlines()
# {/fact}
