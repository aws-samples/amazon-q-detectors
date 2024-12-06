#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-subprocess-call@v1.0 defects=1}
import subprocess, shlex

def nonconformant_case():
    with open("~/output.txt", "w") as f:
        command = "~/test.sh"
        # Noncompliant: Uses `subprocess.call` with `stdout = PIPE` or `stderr = PIPE`.
        subprocess.call(shlex.split(command), stdout=subprocess.PIPE)
# {/fact}
