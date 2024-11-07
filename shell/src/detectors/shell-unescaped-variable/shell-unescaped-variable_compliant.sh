#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unescaped-variable@v1.0 defects=0}

# Compliant: Variable expansion properly included within the quoted string.
message="Welcome to $USER's home directory"
echo "$message"

# {/fact}
