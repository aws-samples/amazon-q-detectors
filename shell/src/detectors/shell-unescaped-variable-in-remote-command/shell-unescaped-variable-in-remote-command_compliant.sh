#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-unescaped-variable-in-remote-command@v1.0 defects=0}

# Compliant: `\$HOME` is passed literally to the remote host, expanding to the correct remote home directory.
ssh user@remote "ls -l \$HOME/documents"

# {/fact}
