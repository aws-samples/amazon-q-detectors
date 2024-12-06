# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-raise-exception-and-baseexception@v1.0 defects=1}
def non_compliant(parameter):
    if not isinstance(parameter, int):
        # Noncompliant: Throwing generic exception might cause important error information to be lost.
        raise Exception("param should be an integer")
# {/fact}
