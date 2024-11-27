#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-client-unsanitized-publish@v1.0 defects=1}
import json
import greengrasssdk
from flask import Flask
from django.http import request

app = Flask(__name__)

@app.route("/somemethod")
def flask_non_conformant_1():
    data = request.args.get('data')
    client = greengrasssdk.client('iot-data')
    final_data = json.dumps(data)
    # Noncompliant: Payload is not sanitized before publishing.
    client.publish(topic='sometopic', payload=final_data)
# {/fact}
