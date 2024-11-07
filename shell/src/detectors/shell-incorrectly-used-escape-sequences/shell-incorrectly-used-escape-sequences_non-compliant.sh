#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrectly-used-escape-sequences@v1.0 defects=1}

# Noncompliant: Incorrect use of escape sequences. `\t` is not interpreted as a tab due to missing `$'...'` quoting.
output=Name\tAge\tCity
echo "$output"

# {/fact}
