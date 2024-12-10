#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-joinable-queue@v1.0 defects=1}
import multiprocessing
import requests

def nonconformant_case(jobs, es_url):
    jobs = multiprocessing.JoinableQueue()
    while True:
        try:
            # Noncompliant: Missing `task_done()` call, breaking queue join functionality.
            image, image_name, tag = jobs.get()
            formatted_es_url = es_url.format(image_name)
            files = {'file' : image.content, 'tag' : tag}
            r = requests.post(formatted_es_url, files = files)
        finally:
            return
# {/fact}
