#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-printf-variable-interpolation@v1.0 defects=1}

# Noncompliant: Variables in format string can lead to unexpected behavior.
name="Alice"
printf "Welcome, $name!\n"

# {/fact}
