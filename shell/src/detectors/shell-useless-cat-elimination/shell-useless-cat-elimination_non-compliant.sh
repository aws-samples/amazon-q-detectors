#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-useless-cat-elimination@v1.0 defects=1}

# Noncompliant: Unnecessary use of `cat` to pipe file contents to `grep`.
cat log.txt | grep "error"

# {/fact}
