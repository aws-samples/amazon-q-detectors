#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-auto-add-or-warning-missing-hostkey-policy@v1.0 defects=0}
from paramiko import RejectPolicy
from paramiko.client import SSHClient

def do_not_auto_add_or_warning_missing_hostkey_policy_compliant():
    ssh_client = SSHClient()
    # Compliant: Secure RejectPolicy() is used as missing hostkey policy.
    ssh_client.set_missing_host_key_policy(RejectPolicy())
# {/fact}
