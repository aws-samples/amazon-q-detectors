#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-expr-modernization@v1.0 defects=0}

# Compliant: Using arithmetic expansion and parameter expansion for better performance.
count=$((count + 1))

# {/fact}
