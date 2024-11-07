#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unbraced-array-expansion@v1.0 defects=1}

# Noncompliant: Array index accessed without braces, leading to incorrect expansion.
fruits=("apple" "banana" "cherry")
echo "The second fruit is $fruits[1]"

# {/fact}
