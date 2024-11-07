#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-shells-are-space-sensitive@v1.0 defects=1}

# Noncompliant: Using `<<(cmd)` is an invalid construct.
while read -r line; do
    echo "$line"
done <<(tail -f /var/log/syslog)

# {/fact}
