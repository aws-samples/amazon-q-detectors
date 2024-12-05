#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-subprocess-communicate-timeout-expires@v1.0 defects=1}
import subprocess, shlex

def nonconformant_case():
    command = "ls -al"
    proc = subprocess.Popen(shlex.split(command), bufsize=-1, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        # Noncompliant: Fails to terminate the child process before the timeout expires.
        outs, errs = proc.communicate(timeout=15)
    except subprocess.TimeoutExpired:
        print("Timed out")
# {/fact}
