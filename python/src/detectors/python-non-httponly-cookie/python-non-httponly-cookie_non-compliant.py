#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-httponly-cookie@v1.0 defects=1}
from http.cookies import SimpleCookie

def stdlib_non_compliant():
    cookie = SimpleCookie()
    cookie['cookie_key'] = "cookie_value"
    # Noncompliant: `httponly` is set to `False`, allowing client-side scripts to access the cookie, which could lead to security vulnerabilities.
    cookie['cookie_key']['httponly'] = False
# {/fact}
