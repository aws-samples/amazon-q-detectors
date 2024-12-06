#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-subprocess-communicate@v1.0 defects=0}
import subprocess, shlex

def conformant_case():
    command = "echo 'hello world!'"
    process = subprocess.Popen(shlex.split(command), stdout=subprocess.PIPE)
    # Compliant: Using `communicate()` method properly handles process output and completion.
    print(process.communicate()[0])
# {/fact}
