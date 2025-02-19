// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-csrf-before-method-override@v1.0 defects=0}
const express = require('express');

// Compliant: `csrf` protection has been correctly added after `method override` leading to adequate CSRF validation.
express.methodOverride()
express.csrf()

// {/fact}
