# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-directly-modify-dict@v1.0 defects=0}
import os

def compliant():
    values = {
        'original_path': os.path,
        'custom_attribute': 'Some custom value',
        '__name__': 'os',
        '__doc__': os.__doc__,
    }
    for key, value in values.items():
        # Compliant: Using `setattr()` to avoid direct manipulation of the `__dict__` attribute.
        setattr(os, key, value)
# {/fact}
