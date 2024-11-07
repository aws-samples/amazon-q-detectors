#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-glob-pattern-safety@v1.0 defects=1}

# Noncompliant: If a filename starts with `-`, it may be interpreted as an option.
ls *

# {/fact}
