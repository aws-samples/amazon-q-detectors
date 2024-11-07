#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unnecessary-variable-expansion@v1.0 defects=1}

# Noncompliant: Unnecessary use of `$` in arithmetic context.
total=$((${count} + ${offset}))

# {/fact}
