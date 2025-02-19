// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-jwt-exposed-credential@v1.0 defects=0}
const jwt = require('jsonwebtoken');

const payload = {
    // Compliant: Contains only non-sensitive data (no passwords or sensitive info).
    userId: '123456',
    username: 'john_doe'
};

const secretKey = process.env.JWT_SECRET;
const token = jwt.sign(payload, secretKey, { expiresIn: '1h' });

console.log('Generated JWT:', token);
// {/fact}
