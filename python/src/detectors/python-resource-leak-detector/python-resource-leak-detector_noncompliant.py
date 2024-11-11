#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-resource-leak-detector@v1.0 defects=1}
def read_file_noncompliant(filename):
    f = open(filename, 'r')
    # Noncompliant: File not closed after processing.
    return f.readlines()
# {/fact}
