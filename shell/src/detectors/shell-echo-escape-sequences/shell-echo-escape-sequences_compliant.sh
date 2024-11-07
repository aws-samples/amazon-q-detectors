#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0
	 
# {fact rule=shell-echo-escape-sequences@v1.0 defects=0}

# Compliant: `printf` interprets `\n` as a newline, properly formatting the output.
printf "First line\nSecond line\n"

# {/fact}
