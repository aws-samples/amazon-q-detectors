#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-avoid-ls-grep@v1.0 defects=0}

# Compliant: Using glob pattern matching handles special characters safely.
echo "Files containing 'config' in the current directory:"
for file in *config*; do
    [ -e "$file" ] && echo "$file"
done

# {/fact}
