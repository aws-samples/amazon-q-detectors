// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-csrf-before-method-override@v1.0 defects=1}
const express = require("express")

function noncompliant() {
    // Noncompliant: `csrf` used before method override.
    express.csrf()
    express.methodOverride()
}
// {/fact}