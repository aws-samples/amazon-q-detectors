#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrect-redirection-order@v1.0 defects=1}

# Noncompliant: `stderr` is redirected to the original `stdout` before `stdout` is redirected to a file.
ls -l /nonexistent 2>&1 > output.txt

# {/fact}
