#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-ps-grep-alternative@v1.0 defects=1}

# Noncompliant: Grepping `ps` output.
if ps aux | grep -v grep | grep "apache2" > /dev/null; then
    echo "Apache is running"
else
    echo "Apache is not running"
fi

# {/fact}
