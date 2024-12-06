# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-raise-exception-and-baseexception@v1.0 defects=0}
def compliant(parameter):
    if not isinstance(parameter, int):
        # Noncompliant: Throwing built in exception to avoid losing important error information.
        raise ValueError("param should be an integer")
# {/fact}
