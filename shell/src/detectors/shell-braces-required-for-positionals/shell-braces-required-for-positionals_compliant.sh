#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-braces-required-for-positionals@v1.0 defects=0}

# Compliant: Uses `${11}`, properly referencing the `11th` argument.
echo "The 11th argument is ${11}"

# {/fact}
