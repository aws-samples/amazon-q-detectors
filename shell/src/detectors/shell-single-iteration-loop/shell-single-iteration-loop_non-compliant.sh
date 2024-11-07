#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-single-iteration-loop@v1.0 defects=1}

# Noncompliant: This loop will only run once.
for file in myfile.txt
do
    echo "Processing $file"
done

# {/fact}
