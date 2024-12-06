#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-correctly-invoke-shell@v1.0 defects=0}
import subprocess

def compliant():
    # Compliant: Validation on commands received from external output is present.
    subprocess.call("ls", shell=True)

# {/fact}
