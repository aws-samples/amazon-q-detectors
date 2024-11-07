#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-find-patterns@v1.0 defects=1}

# Noncompliant: Unquoted parameter can lead to unexpected behavior if files matching the pattern exist in the current directory.
find . -name *.log

# {/fact}
