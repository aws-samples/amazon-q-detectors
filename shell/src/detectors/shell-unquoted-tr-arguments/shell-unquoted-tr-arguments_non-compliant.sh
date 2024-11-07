#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-tr-arguments@v1.0 defects=1}

# Noncompliant: Unquoted `tr` parameters can lead to unintended glob expansion.
echo "Hello, World!" | tr [:lower:] [:upper:]

# {/fact}
