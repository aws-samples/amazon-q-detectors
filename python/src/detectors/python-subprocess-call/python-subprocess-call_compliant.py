#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-subprocess-call@v1.0 defects=0}
import subprocess, shlex

def conformant_case():
    with open("~/output.txt", "w") as f:
        # Compliant: Uses `subprocess.call` without `stdout = PIPE` or `stderr = PIPE`.
        command = "~/test.sh"
        subprocess.call(shlex.split(command), stdout=f)
# {/fact}
