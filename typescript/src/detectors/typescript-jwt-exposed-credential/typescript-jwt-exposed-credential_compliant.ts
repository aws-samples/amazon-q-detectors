// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-jwt-exposed-credential@v1.0 defects=0}
import jwt from 'jsonwebtoken';

interface Payload {
    userId: string;
    username: string;
    role: string;
}

const payload: Payload = {
    userId: '123456',
    username: 'john_doe',
    role: 'admin'
};

// Compliant: Secret key is securely stored and not hardcoded.
const secretKey: string | undefined = process.env.JWT_SECRET;

if (secretKey) {
    const token = jwt.sign(payload, secretKey, { expiresIn: '1h' });

    console.log('Generated JWT:', token);
} else {
    console.error('JWT_SECRET is not set in environment variables');
}
// {/fact}
