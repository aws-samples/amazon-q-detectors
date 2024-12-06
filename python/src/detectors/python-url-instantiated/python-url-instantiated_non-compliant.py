# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-url-instantiated@v1.0 defects=1}
import urllib.request

def non_compliant():
    # Noncompliant: URL is using an unencrypted `HTTP` protocol connection.
    urllib.request.Request('http://www.abc/zyx')
# {/fact}
