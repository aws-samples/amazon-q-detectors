#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-exit-class-method-re-raise-exception@v1.0 defects=0}
class ContextManager:
    
    def __enter__(self):
        return self

    def __exit__(self):
       # Compliant: Allows the context manager to cleanly exit without re-raising or propagating exceptions.
       pass
# {/fact}
