#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-unescaped-variable-in-remote-command@v1.0 defects=1}

# Noncompliant: `$HOME` expands on the client side, potentially using the wrong home directory.
ssh user@remote "ls -l $HOME/documents"

# {/fact}
