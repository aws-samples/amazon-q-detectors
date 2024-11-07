#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-sudo-redirect-misuse@v1.0 defects=0}

# Compliant: Uses `tee` to write with `sudo` privileges.
echo "New setting" | sudo tee /etc/myapp/settings.conf > /dev/null

# {/fact}
