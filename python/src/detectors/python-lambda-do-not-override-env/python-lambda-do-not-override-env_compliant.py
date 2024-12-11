# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-lambda-do-not-override-env@v1.0 defects=0}
import os


def compliant():
    # Compliant: Using a different environment variable name that is not reserved by `AWS Lambda`.
    os.environ['CUSTOM_HANDLER'] = "value"
# {/fact}
