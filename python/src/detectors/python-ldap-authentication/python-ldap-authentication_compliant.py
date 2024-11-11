#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ldap-authentication@v1.0 defects=0}
import ldap
import os

def authenticate_connection_compliant():
    connect = ldap.initialize('ldap://127.0.0.1:1389')
    connect.set_option(ldap.OPT_REFERRALS, 0)
    # Compliant: Simple security authentication used.
    connect.simple_bind('cn=root', os.environ.get('LDAP_PASSWORD'))
# {/fact}
