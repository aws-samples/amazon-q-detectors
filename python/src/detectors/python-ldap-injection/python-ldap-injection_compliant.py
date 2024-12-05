#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ldap-injection@v1.0 defects=0}
import ldap
from flask import app

@app.route('/getUsers')
def conformant(request):
    username = request.args['username']
    filter_string = "(uid=%s)" % ('username')
    ldap_conn = ldap.initialize('ldaps://ldap.amazon.com:636')
    # Compliant: User-supplied filter is checked for allowed characters.
    result = ldap_conn.search('o=amazon.com', ldap.SCOPE_SUBTREE, filter_string)
    return result
# {/fact}
