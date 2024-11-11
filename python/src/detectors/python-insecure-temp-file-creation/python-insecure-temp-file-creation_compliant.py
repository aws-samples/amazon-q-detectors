#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-temp-file-creation@v1.0 defects=0}
import tempfile

def create_temp_file_compliant(results):
    # Compliant: Uses NamedTemporaryFile() to securely create a temporary file.
    with tempfile.NamedTemporaryFile(mode="w+", delete=False) as f:
        f.write(results)
    print("Results written to", f.name)
# {/fact}
