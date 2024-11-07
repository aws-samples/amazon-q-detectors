#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-command-substitution-execution@v1.0 defects=1}

# Noncompliant: Attempts to execute the output of `ls` instead of running `ls`.
$(ls -l /tmp)

# {/fact}
