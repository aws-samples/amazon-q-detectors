# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-lambda-do-not-override-env@v1.0 defects=1}
import os


def non_compliant():
    # Noncompliant: Overriding reserved environment variable names in a lambda function can lead to unexpected behavior.
    os.environ['_HANDLER'] = "value"
# {/fact}
