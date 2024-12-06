# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-directly-modify-dict@v1.0 defects=1}
import os

def non_compliant():
    values = {
        'original_path': os.path,
        'custom_attribute': 'Some custom value',
        '__name__': 'os',
        '__doc__': os.__doc__,
    }
    # Noncompliant: Modifies the `__dict__` object directly may leads to direct manipulation of the `__dict__` attribute.
    os.__dict__ = values
# {/fact}
