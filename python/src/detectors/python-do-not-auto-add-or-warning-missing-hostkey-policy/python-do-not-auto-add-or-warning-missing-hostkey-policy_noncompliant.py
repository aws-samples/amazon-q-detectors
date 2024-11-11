#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-do-not-auto-add-or-warning-missing-hostkey-policy@v1.0 defects=1}
from paramiko import AutoAddPolicy
from paramiko.client import SSHClient

def do_not_auto_add_or_warning_missing_hostkey_policy_noncompliant():
    ssh_client = SSHClient()
    # Noncompliant: Insecure AutoAddPolicy() is used as missing hostkey policy.
    ssh_client.set_missing_host_key_policy(policy=AutoAddPolicy())
# {/fact}
