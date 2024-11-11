#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-basic-authentication-in-request@v1.0 defects=0}
import urllib3 as urllib3
import ssl

def http_request_compliant(authorization, url):
    # Compliant: No weak encoding used for basic authentication.
    headers = {'Authorization': 'Basic %s' % authorization}
    urllib3.disable_warnings()
    http = urllib3.PoolManager(ssl_minimum_version=ssl.TLSVersion.TLSv1_2)
    response = http.request('GET', url, headers=headers)
# {/fact}
