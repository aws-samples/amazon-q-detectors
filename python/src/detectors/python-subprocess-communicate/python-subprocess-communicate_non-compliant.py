#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-subprocess-communicate@v1.0 defects=1}
import subprocess, shlex

def nonconformant_case(source):
    command = 'sh ~/test.sh'
    popen = subprocess.Popen(shlex.split(command), stdin=subprocess.PIPE)
    # Noncompliant: Direct `stdin.write()` without `communicate()` risks deadlocks and resource leaks.
    output = popen.stdin.write(source.encode("utf8"))
    print(output)
# {/fact}
