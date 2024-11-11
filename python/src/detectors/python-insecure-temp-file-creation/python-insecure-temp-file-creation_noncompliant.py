#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-temp-file-creation@v1.0 defects=1}
import tempfile

def create_file_noncompliant(results):
    # Noncompliant: Uses mktemp() to generate a temporary file path, which is insecure.
    filename = tempfile.mktemp()
    with open(filename, "w+") as f:
        f.write(results)
    print("Results written to", filename)
# {/fact}
