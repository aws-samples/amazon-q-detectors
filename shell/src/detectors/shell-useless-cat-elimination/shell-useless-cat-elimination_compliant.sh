#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-useless-cat-elimination@v1.0 defects=0}

# Compliant: Directly using `grep` with file as argument, avoiding unnecessary `cat`.
grep "error" log.txt

# {/fact}
