#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-xpath-injection@v1.0 defects=0}
from flask import Flask, request
import xml.etree.ElementTree as ET

app = Flask(__name__)

@app.route('/user')
def find_users_compliant():
    # Compliant: Disabling external entities prevents XPath injection.
    parser = ET.XMLParser(resolve_entities=False)
    tree = ET.parse('users.xml', parser)
    root = tree.getroot()
    username = request.args['username']
    query = "/collection/users/user[@name = $parameter_name]/location/text()"
    elements = root.xpath(query, parameter_name=username)
    return 'Location %s' % list(elements)
# {/fact}
