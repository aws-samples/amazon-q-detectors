#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-correctly-invoke-shell@v1.0 defects=0}
import subprocess
import sys
import shlex

def compliant():
    command = shlex.quote(sys.argv[0])
    # Compliant: Sanitization on commands received from external output is present.
    subprocess.call(command, shell=True)

# {/fact}
