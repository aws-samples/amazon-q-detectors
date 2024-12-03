# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-xxe-external-entity@v1.0 defects=1}
from flask import Flask, request
from lxml import etree

app = Flask(__name__)

@app.post("/upload")
def non_compliant():
    xml_src = request.get_data()
    # Noncompliant: Using `lxml.etree.fromstring` can be vulnerable to an XXE attack.
    doc = etree.fromstring(xml_src)
    return etree.tostring(doc)
# {/fact}
