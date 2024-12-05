#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prevent-data-corruption@v1.0 defects=1}
import multiprocessing

def worker(queue):
    queue.put("Worker completed")

def nonconformant_case():
    queue = multiprocessing.Queue()
    p = multiprocessing.Process(target=worker, args=(queue,))
    p.start()
    # Noncompliant: Unsafe termination of process with shared Queue risks data corruption.
    p.terminate()
# {/fact}
