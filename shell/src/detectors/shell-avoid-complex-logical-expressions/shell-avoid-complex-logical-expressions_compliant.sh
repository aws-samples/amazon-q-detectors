#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-avoid-complex-logical-expressions@v1.0 defects=0}

# Compliant: Using proper `if-then-else` construct for safety.
file="/path/to/important/file.txt"
if [[ -f $file ]]; then
    echo "File exists: $file" > /dev/null
else
    rm "$file"
fi

# {/fact}
