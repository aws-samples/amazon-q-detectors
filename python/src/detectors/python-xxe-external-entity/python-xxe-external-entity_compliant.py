# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-xxe-external-entity@v1.0 defects=0}
from flask import Flask, request
from defusedxml.lxml import fromstring
from defusedxml import lxml

app = Flask(__name__)

@app.post("/upload")
def compliant():
    xml_src = request.get_data()
    # Compliant: Using `defusedxml.lxml.fromstring` helps prevent XXE injection.
    doc = fromstring(xml_src) 
    return lxml.etree.tostring(doc)
# {/fact}
