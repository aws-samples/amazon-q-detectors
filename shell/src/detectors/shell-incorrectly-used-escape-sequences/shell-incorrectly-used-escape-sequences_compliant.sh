#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrectly-used-escape-sequences@v1.0 defects=0}

# Compliant: Correctly creates a CSV-like output with tabs.
output="Name$(printf '\t')Age$(printf '\t')City"
echo "$output"

# {/fact}
