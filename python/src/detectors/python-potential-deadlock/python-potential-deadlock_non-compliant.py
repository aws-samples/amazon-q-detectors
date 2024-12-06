#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-potential-deadlock@v1.0 defects=1}
import shlex
from subprocess import Popen, PIPE

def nonconformant_case():
    command = 'sh ~/example.sh'
    process = Popen(shlex.split(command), stdout=PIPE)
    # Noncompliant: Uses the `Popen.wait` with `stdout=PIPE` or `stderr=PIPE`, resulting in a potential deadlock and busy loop.
    process.wait()
    output = process.stdout.read()
    print(output)
# {/fact}
