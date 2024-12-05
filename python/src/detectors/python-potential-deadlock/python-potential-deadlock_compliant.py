#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-potential-deadlock@v1.0 defects=0}
import shlex
from subprocess import Popen, PIPE

def conformant_case():
    command = 'sh ~/example.sh'
    process = Popen(shlex.split(command), stdout=PIPE)
    # Compliant: Uses `Popen.communicate` method, avoiding a potential deadlock and busy loop.
    print(process.communicate()[0])
# {/fact}
