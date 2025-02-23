#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-create-httpsconnection-pool@v1.0 defects=1}
import urllib3

def non_compliant():
    # Noncompliant: `HTTPConnectionPool` transmits data in cleartext.
    pool = urllib3.connectionpool.HTTPConnectionPool("example.com")

# {/fact}
