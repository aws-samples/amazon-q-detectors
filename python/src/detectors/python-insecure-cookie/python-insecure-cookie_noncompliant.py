#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-cookie@v1.0 defects=1}
from http.cookies import SimpleCookie

def secure_cookie_noncompliant():
    cookie = SimpleCookie()
    cookie['sample'] = "sample_value"
    # Noncompliant: The cookie is insecure.
    cookie['sample']['secure'] = False
    print(cookie)
# {/fact}
