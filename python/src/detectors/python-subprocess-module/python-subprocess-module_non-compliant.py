#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unnecessary-iteration@v1.0 defects=1}
import os

def nonconformant_case():
    # Noncompliant: Using `os.system()` can introduce security vulnerabilities and lacks control over the child process.
    os.system('ls')
    return 0
# {/fact}
