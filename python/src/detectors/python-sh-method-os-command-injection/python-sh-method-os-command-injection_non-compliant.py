#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sh-method-os-command-injection@v1.0 defects=1}
import sh
import os

def non_compliant():
    long = os.environ.get("LONG", "")
    # Noncompliant: String concatenation or formatting in calls to commands via `sh` can leads to Command Injection vulnerabilities.
    sh.ls("-a" + long)
# {/fact}
