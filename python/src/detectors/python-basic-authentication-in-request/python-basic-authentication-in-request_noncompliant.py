#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-basic-authentication-in-request@v1.0 defects=1}
import urllib3 as urllib3
from base64 import b64encode

def http_request_noncompliant(username, password, url):
    userpass = "%s:%s" % (username, password)
    # Noncompliant: Weak encoding used in HTTP Basic Authentication.
    authorization = b64encode(str.encode(userpass)).decode("utf-8")
    headers = {'Authorization': 'Basic %s' % authorization}
    urllib3.disable_warnings()
    http = urllib3.PoolManager()
    response = http.request('GET', url, headers=headers)
# {/fact}
