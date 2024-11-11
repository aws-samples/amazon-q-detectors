#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-literal-import@v1.0 defects=1}
import importlib

def module_injection_noncompliant():
    module_name = input('module name')
    # Noncompliant: Untrusted user input is being passed to import_module().
    importlib.import_module(module_name)
# {/fact}
