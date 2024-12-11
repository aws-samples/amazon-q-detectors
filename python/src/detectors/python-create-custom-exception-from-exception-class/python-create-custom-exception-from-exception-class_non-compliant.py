# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-create-custom-exception-from-exception-class@v1.0 defects=1}
# Noncompliant: Throwing a `BaseException` can obscure critical error details.
class BaseSSLError(BaseException):
    pass
# {/fact}
