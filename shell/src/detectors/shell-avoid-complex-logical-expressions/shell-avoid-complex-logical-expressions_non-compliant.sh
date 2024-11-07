#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-avoid-complex-logical-expressions@v1.0 defects=1}

# Noncompliant: This construct can lead to unexpected behavior.
file="/path/to/important/file.txt"
[[ -f $file ]] && echo "File exists: $file" > /dev/null || rm "$file"

# {/fact}
