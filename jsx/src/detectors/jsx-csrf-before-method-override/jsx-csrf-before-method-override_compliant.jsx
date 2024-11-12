// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-csrf-before-method-override@v1.0 defects=0}
const express = require("express");

function compliant() {
    // Compliant: Method overrride used before `csrf`.
    express.methodOverride()
    express.csrf()
}
// {/fact}