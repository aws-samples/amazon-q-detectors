# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-hardcode-security-sensitive-credentials@v1.0 defects=1}
def non_compliant():
    # Noncompliant: Hardcoded secrets might allow unauthorized users to access your account.
    password = "password"
# {/fact}
