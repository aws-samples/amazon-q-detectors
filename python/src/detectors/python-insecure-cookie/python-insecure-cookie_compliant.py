#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-insecure-cookie@v1.0 defects=0}
from http.cookies import SimpleCookie

def secure_cookie_compliant():
    cookie = SimpleCookie()
    cookie['sample'] = "sample_value"
    # Compliant: The cookie is secure.
    cookie['sample']['secure'] = True
    print(cookie)
# {/fact}
