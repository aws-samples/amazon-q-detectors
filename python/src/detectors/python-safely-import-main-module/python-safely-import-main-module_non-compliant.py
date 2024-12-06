#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-safely-import-main-module@v1.0 defects=1}
from multiprocessing import Process, set_start_method

def conformant_case_fork():
    print('fork use case!!')

set_start_method('fork', force = True)
# Noncompliant: Fails to import the main module prior to executing the function.
Process(target = conformant_case_fork).start()
# {/fact}
