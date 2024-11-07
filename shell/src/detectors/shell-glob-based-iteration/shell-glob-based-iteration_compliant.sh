#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=shell-glob-based-iteration@v1.0 defects=0}

# Compliant: This correctly handles all filenames, including those with spaces or special characters.
shopt -s nullglob
for img in *.jpg
do
    [[ -e "$img" ]] || continue
    convert "$img" "${img%.jpg}.png"
done

# {/fact}
