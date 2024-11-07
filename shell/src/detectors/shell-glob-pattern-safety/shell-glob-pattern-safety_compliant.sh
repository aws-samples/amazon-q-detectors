#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-glob-pattern-safety@v1.0 defects=0}

# Compliant: Using `--` tells `ls` to treat all following arguments as filenames.
ls -- *

# {/fact}
