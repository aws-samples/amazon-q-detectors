#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-publicly-writable-directories@v1.0 defects=0}
import tempfile
import os

def compliant():
    # Compliant: Use a dedicated sub-folder with controlled permission or secure-by-design APIs to create temporary files.
    with tempfile.TemporaryFile(dir="/tmp/my_subdirectory/", mode="w+") as file:
        pass
# {/fact}
