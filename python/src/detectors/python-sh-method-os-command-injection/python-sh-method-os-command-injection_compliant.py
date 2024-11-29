#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sh-method-os-command-injection@v1.0 defects=0}
import sh

def compliant():
    # Compliant: Avoid using string concatenation or formatting when constructing command calls.
    sh.Command("--config", "something")
# {/fact}
