#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unbraced-array-expansion@v1.0 defects=0}

# Compliant: Array index accessed with braces, ensuring proper expansion.
fruits=("apple" "banana" "cherry")
echo "The second fruit is ${fruits[1]}"

# {/fact}
