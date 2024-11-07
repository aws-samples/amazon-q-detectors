#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-find-loop-safety@v1.0 defects=0}

# Compliant: This correctly handles filenames with spaces and special characters.
find ./documents -type f -name "*.txt" -print0 | while IFS= read -r -d '' file
do
    echo "Processing: $file"
    wc -l "$file"
done

# {/fact}
