#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-unnecessary-iteration@v1.0 defects=0}
import subprocess, shlex

def conformant_case():
    # Compliant: Using `subprocess.call()` provides better control and security.
    command = 'ls'
    subprocess.call(shlex.split(command))
    return 0
# {/fact}
