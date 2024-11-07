#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-prefer-find-over-ls@v1.0 defects=1}

# Noncompliant: `ls` output can be inconsistent and break with special characters.
ls -l | grep 'somefile*' | grep '\.log$'
NUMFILES=$(ls *.txt | wc -l)

# {/fact}
