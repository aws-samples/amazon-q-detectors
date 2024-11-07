#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-arithmetic-expansion-modernization@v1.0 defects=0}

# Compliant: Using the standard `$((..))` syntax for arithmetic operations.
x=5
y=3
result=$((x * y))
echo "Result: $result"

# {/fact}
