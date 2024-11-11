#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-literal-import@v1.0 defects=0}
import importlib

def module_injection_compliant():
    allowed_module_names_list = ['example_module1', 'example_module2']
    module_name = input('module name')
    if module_name in allowed_module_names_list:
        # Compliant: User input is validated before using in import_module().
        importlib.import_module(module_name)
# {/fact}
