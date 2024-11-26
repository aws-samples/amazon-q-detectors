#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-correctly-invoke-shell@v1.0 defects=1}
import subprocess
import sys

def non_compliant():
    command = sys.argv[0]
    # Noncompliant: Sanitization on commands received from external output is absent.
    subprocess.call(command, shell=True)

# {/fact}
