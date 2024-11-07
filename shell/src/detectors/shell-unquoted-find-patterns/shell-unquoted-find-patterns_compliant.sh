#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-find-patterns@v1.0 defects=0}

# Compliant: Quoted parameter ensures the pattern is passed to `find` as intended.
find . -name '*.log'

# {/fact}
