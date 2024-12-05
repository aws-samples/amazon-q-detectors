#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prevent-data-corruption@v1.0 defects=0}
import multiprocessing

def wrapper(queue):
    queue.put("Worker completed")

def conformant_case():
    p = multiprocessing.Process(target=wrapper, args=(10,))
    p.start()
    # Compliant: Safe process termination using wrapper function.
    p.terminate()
# {/fact}
