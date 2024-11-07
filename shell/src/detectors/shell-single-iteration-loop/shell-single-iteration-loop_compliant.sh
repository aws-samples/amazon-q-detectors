#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-single-iteration-loop@v1.0 defects=0}

# Compliant: Correct usage of `for` loop to iterate over files.
for file in *.txt
do
    echo "Processing $file"
done

# {/fact}
