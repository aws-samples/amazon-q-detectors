#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ldap-injection@v1.0 defects=1}
from flask import app
import ldap
from flask import request

@app.route('/getUsers')
def non_conformant():
    username = request.args['username']
    filter_string = '(uid=' + username + ')'
    ldap_conn = ldap.initialize('ldaps://ldap.amazon.com:636')
    # Noncompliant: User-supplied filter is not sanitized.
    result = ldap_conn.search_s('o=amazon.com', ldap.SCOPE_SUBTREE, filter_string)
    return result
# {/fact}
