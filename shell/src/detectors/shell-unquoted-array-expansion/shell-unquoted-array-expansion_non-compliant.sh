#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-array-expansion@v1.0 defects=1}

# Noncompliant: Unquoted array expansion can lead to word splitting and globbing.
rm $@

# {/fact}
