#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-oscommandinjectionrule@v1.0 defects=0}
import shlex
from flask import request, Flask
import paramiko

app = Flask(__name__)

@app.route('/some_url')
def exec_command_compliant():
    client = paramiko.SSHClient()
    address = request.args.get("address")
    # Compliant: Address argument is shell escaped.
    address = shlex.quote(request.args.get("address"))
    cmd = "ping -c 1 %s" % address
    client = client.SSHClient()
    client.connect("ssh.samplehost.com")
    client.exec_command(cmd)
# {/fact}
