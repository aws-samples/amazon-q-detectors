#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unsupported-decimal-comparison@v1.0 defects=0}

# Compliant: Using `bc` to compare decimal numbers.
if [[ $(echo "0.5 == 0.50" | bc -l) -eq 1 ]]; then
    echo "The numbers are equal"
fi

# {/fact}
