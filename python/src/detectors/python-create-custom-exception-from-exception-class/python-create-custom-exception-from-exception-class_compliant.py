# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-create-custom-exception-from-exception-class@v1.0 defects=0}
# Compliant: Custom exceptions is inheriting from `Exception` instead of `BaseException`.
class BaseSSLError(Exception):
    pass
# {/fact}
