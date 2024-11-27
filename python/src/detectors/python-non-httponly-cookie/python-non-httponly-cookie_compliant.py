#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-non-httponly-cookie@v1.0 defects=0}
from http.cookies import SimpleCookie

def stdlib_compliant1():
    cookie = SimpleCookie()
    cookie['c1'] = "value"
    # Compliant: `httponly` is set to `True`, preventing client-side scripts from accessing the cookie.
    cookie['c3']['httponly'] = True
# {/fact}
