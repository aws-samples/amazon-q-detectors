#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-incomplete-regular-expression-for-hostnames@v1.0 defects=1}
import re

def non_compliant():
    # Noncompliant: Matching hostname with an unescaped dot in regex.
    rv=re.compile("http://(.*).example.com")
# {/fact}
