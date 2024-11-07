#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-braces-required-for-positionals@v1.0 defects=1}

# Noncompliant: Uses `$11`, which will be interpreted as `$1` followed by `1` or `0`.
echo "The 11th argument is $11"

# {/fact}
