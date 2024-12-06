#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-exit-class-method-re-raise-exception@v1.0 defects=1}
class ContextManager:

    def __enter__(self):
        return self

    def __exit__(self, exc_value):
        a = 1
        b = 2
        if a == 1:
            # Noncompliant: Re-raises the exception caught by the context manager, potentially leading to unexpected behavior or masking the original exception.
            raise exc_value
# {/fact}
