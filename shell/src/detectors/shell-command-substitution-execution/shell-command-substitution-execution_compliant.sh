#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-command-substitution-execution@v1.0 defects=0}

# Compliant: Simply runs the `ls` command without trying to execute its output.
ls -l /tmp

# {/fact}
