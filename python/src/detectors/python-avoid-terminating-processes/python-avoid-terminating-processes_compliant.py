# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-terminating-processes@v1.0 defects=0}
import multiprocessing as mp
from queue import Empty

def compliant():
    mp_queue = mp.Queue()
    sem = mp.Semaphore(2)
    n = 10
    interval = 0.1
    p = mp.Process(target=_enqueue_on_interval, args=(mp_queue, n, interval, sem))
    p.start()
    
    while p.is_alive():
        try:
            item = mp_queue.get(timeout=1)
            print(f"Processing item: {item}")
        except Empty:
            continue
    # Compliant: By using `.join()` method, shared processes remain stable and available.
    p.join(timeout=30)

    while not mp_queue.empty():
        try:
            item = mp_queue.get_nowait()
            print(f"Processing remaining item: {item}")
        except Empty:
            break
# {/fact}
