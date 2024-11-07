#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-array-expansion@v1.0 defects=0}

# Compliant: Quoted array expansion preserves array elements with spaces and prevents globbing.
rm "$@"

# {/fact}
