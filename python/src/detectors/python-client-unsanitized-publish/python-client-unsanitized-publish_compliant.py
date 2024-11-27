#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-client-unsanitized-publish@v1.0 defects=0}
import json
import greengrasssdk
from flask import Flask

app = Flask(__name__)

@app.route("/somemethod")
def flask_conformant_1():
    data = "some_data"
    client = greengrasssdk.client('iot-data')
    # Compliant: The payload data is properly serialized using `json.dumps` before publishing, ensuring data integrity.
    client.publish(topic='123', qos=1, payload=json.dumps(data))
# {/fact}
