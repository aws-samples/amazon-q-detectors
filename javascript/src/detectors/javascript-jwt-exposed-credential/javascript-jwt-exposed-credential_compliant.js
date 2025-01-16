// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-jwt-exposed-credential@v1.0 defects=0}
const jwt = require('jsonwebtoken');

// Compliant: Sensitive data like 'password' is not being sent in the payload.
const payload = {
    userId: '123456',
    username: 'john_doe',
    role: 'admin'
};

const secretKey = process.env.JWT_SECRET;
const token = jwt.sign(payload, secretKey, { expiresIn: '1h' });

console.log('Generated JWT:', token);
// {/fact}
