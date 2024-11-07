#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-tr-arguments@v1.0 defects=0}

# Compliant: Quoted `tr` parameters prevent glob expansion, ensuring correct character class usage.
echo "Hello, World!" | tr '[:lower:]' '[:upper:]'

# {/fact}
