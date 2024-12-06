#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-safely-import-main-module@v1.0 defects=0}
import multiprocessing

def conformant_case_fork(persistent_object):
   print(f'fork use case with {persistent_object}!!')

if __name__ == '__main__':
    persistent_obj = object()
    multiprocessing.set_start_method('fork', force=True)
    # Compliant: Safely imports the main module prior to executing the function.
    multiprocessing.Process(target=conformant_case_fork, args=(persistent_obj,)).start()
# {/fact}
