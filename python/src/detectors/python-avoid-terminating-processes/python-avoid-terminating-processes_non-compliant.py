# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-avoid-terminating-processes@v1.0 defects=1}
import multiprocessing as mp

def non_compliant():
    mp_queue = mp.Queue()
    n = 10
    interval = 0.1
    sem = mp.Semaphore(0)
    p = mp.Process(target=_enqueue_on_interval, args=(mp_queue, n, interval, sem))
    p.start()
    # Noncompliant: By using `Process.terminate()`, shared processes could break or become unavailable.
    p.terminate()
# {/fact}
