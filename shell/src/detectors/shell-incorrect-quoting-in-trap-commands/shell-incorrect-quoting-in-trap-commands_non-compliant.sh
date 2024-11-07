#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-incorrect-quoting-in-trap-commands@v1.0 defects=1}

# Noncompliant: Double quotes cause immediate expansion of the date command.
trap "echo \"Script finished at $(date)\"" EXIT

# {/fact}
