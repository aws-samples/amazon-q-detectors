# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-url-instantiated@v1.0 defects=0}
import urllib.request

def compliant():
    # Compliant: URL is using an secure `HTTPS` protocol connection.
    urllib.request.Request('https://www.abc/zyx')
# {/fact}
