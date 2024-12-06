# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-hardcode-security-sensitive-credentials@v1.0 defects=0}
import os

def compliant():
    # Compliant: Retrieves the secrets of the specified environment variable from the operating system.
    password = os.getenv("ENVIRONMENT_VARIABLE_VALUE")
# {/fact}
