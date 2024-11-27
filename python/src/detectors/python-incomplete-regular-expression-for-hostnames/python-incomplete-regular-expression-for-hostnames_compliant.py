#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-incomplete-regular-expression-for-hostnames@v1.0 defects=0}
import re

def compliant():
    # Compliant: Matching hostname with an escaped dot in regex.
    urlRegex = ("http://(\\.*)\\.example\\.com")
    urls = re.compile(urlRegex)
    url = "https://amazon.co.in"
    re.match(urls, url)
# {/fact}
