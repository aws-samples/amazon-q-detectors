#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-unquoted-special-parameters@v1.0 defects=1}

# Noncompliant: Word splitting occurs, breaking arguments with spaces.
copy_files() {
    cp $* /backup/
}

# {/fact}
