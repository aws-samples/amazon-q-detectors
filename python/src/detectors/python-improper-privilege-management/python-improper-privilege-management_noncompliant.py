#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-improper-privilege-management@v1.0 defects=1}
import os

def set_user_noncompliant():
    root = 0
    # Noncompliant: The process user is set to `root`.
    os.setuid(root)
# {/fact}
