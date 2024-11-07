#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-echo-escape-sequences@v1.0 defects=1}

# Noncompliant: `echo` doesn't interpret `\n` as a newline, resulting in literal output of `\n`.
echo "First line\nSecond line"

# {/fact}
