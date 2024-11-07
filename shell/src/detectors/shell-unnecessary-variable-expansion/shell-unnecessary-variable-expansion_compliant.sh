#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unnecessary-variable-expansion@v1.0 defects=0}

# Compliant: Simplified arithmetic expression without `$`.
total=$((count + offset))

# {/fact}
