#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-expr-modernization@v1.0 defects=1}

# Noncompliant: `expr` is antiquated and can be slower.
count=$(expr $count + 1)

# {/fact}
