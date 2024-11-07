#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-command-substitution-syntax@v1.0 defects=1}

# Noncompliant: Backticks are legacy syntax and hard to nest.
current_dir=`pwd`

# {/fact}
