#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prevent-process-deadlock@v1.0 defects=1}
from multiprocessing import Process, Queue

def f(q):
    q.put('X' * 1000000)

def noncompliant_case():
    queue = Queue()
    p = Process(target=f, args=(queue,))
    p.start()
    # Noncompliant: Causes deadlock by joining the process before reading from the queue, leaving the child process stuck trying to write to a full queue.
    p.join()   
# {/fact}
