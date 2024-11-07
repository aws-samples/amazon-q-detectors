#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-arithmetic-expansion-modernization@v1.0 defects=1}

# Noncompliant: Uses the deprecated `$[..]` syntax.
x=5
y=3
result=$[x * y]
echo "Result: $result"

# {/fact}
