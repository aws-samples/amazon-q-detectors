#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-special-parameters@v1.0 defects=0}

# Compliant: Preserves arguments with spaces.
copy_files() {
    cp "$@" /backup/
}

# {/fact}
