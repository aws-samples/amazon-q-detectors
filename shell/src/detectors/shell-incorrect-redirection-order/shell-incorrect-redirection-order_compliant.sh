#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrect-redirection-order@v1.0 defects=0}

# Compliant: `stdout` redirected to a file, then `stderr` redirected to the new `stdout` (file).
ls -l /nonexistent > output.txt 2>&1

# {/fact}
