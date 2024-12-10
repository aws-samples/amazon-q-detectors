#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-prevent-process-deadlock@v1.0 defects=0}
import multiprocessing as mp
import time

def run(self):
    q = mp.Queue()
    n = self.g.queryNum
    width = n // self.m
    p = []
    start_time = time.time()
    for i in range(self.m):
        start = width * i
        end = min(width * (i + 1), n)
        p.append(mp.Process(target=self.random_walk_multiple_start_node, args=(self.g, list(range(start, end)), 100, 4, self.top_T, q)))
        p[i].start()
    print('finish start for all')

    self.res = []
    total_number_candidate = 0
    for i in range(self.m):
        predict_list, number_candidate = q.get()
        self.res = self.res + predict_list
        total_number_candidate += number_candidate

    print("running time = ", time.time() - start_time)

    # Compliant: Safely reads queue data first before joining processes, preventing deadlock by ensuring the queue is empty before waiting.
    for i in range(self.m):
        p[i].join()
    print("number of candidate per keyword = ", total_number_candidate / n)
# {/fact}
