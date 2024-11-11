#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-xpath-injection@v1.0 defects=1}
from flask import Flask, request
import xml.etree.ElementTree as ET

app = Flask(__name__)

@app.route('/user')
def find_users_noncompliant():
    tree = ET.parse('users.xml')
    root = tree.getroot()
    username = request.args['username']
    query = "./users/user/[@name='"+username+"']/location"
    # Noncompliant: Evaluating expression built from user-supplied parameter can lead to XPath injection.
    elements = root.findall(query)
    return 'Location %s' % list(elements)
# {/fact}
