#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-create-httpsconnection-pool@v1.0 defects=0}
import urllib3

def compliant():
    # Compliant: Usage of `HTTPSConnectonPool` encrypts the data securely during transit.
    pool = urllib3.connectionpool.HTTPSConnectionPool("example.com")

# {/fact}
