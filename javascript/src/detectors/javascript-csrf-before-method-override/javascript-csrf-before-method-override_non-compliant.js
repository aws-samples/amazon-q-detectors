// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-csrf-before-method-override@v1.0 defects=1}
const express = require('express');

// Noncompliant: `csrf` protection added before `method override` which can lead to issues where the CSRF validation fails.
express.csrf()
express.methodOverride()

// {/fact}
