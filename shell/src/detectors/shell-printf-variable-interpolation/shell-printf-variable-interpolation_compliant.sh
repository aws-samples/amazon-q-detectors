#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-printf-variable-interpolation@v1.0 defects=0}

# Compliant: Safely handles variables, even if they contain format specifiers.
name="Alice"
printf "Welcome, %s!\n" "$name"

# {/fact}
