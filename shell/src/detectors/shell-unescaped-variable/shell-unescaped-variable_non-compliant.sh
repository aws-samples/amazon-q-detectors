#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unescaped-variable@v1.0 defects=1}

# Noncompliant: Surrounding quotes unintentionally unquote the variable expansion.
message="Welcome to "$USER"'s home directory"
echo $message

# {/fact}
