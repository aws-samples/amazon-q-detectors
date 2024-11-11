#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-oscommandinjectionrule@v1.0 defects=1}
import shlex
from flask import request, Flask
import paramiko

app = Flask(__name__)

@app.route('/some_url')
def exec_command_noncompliant():
    client = paramiko.SSHClient()
    address = request.args.get("address")
    cmd = "ping -c 1 %s" % address
    client = client.SSHClient()
    client.connect("ssh.samplehost.com")
    # Noncompliant: Address argument is not shell escaped.
    client.exec_command(cmd)
# {/fact}
