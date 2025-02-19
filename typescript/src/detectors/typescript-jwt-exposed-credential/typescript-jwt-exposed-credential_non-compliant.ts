// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-jwt-exposed-credential@v1.0 defects=1}
import jwt from 'jsonwebtoken';

interface Payload {
    userId: string;
    username: string;
    role: string;
    password: string;  
}

// Noncompliant: Password is being incorrectly sent as a part of the payload.
const payload: Payload = {
    userId: '123456',
    username: 'john_doe',
    role: 'admin',
    password: 'abc123'
};

const secretKey: string | undefined = process.env.JWT_SECRET;

if (secretKey) {
    const token = jwt.sign(payload, secretKey, { expiresIn: '1h' });

    console.log('Generated JWT:', token);
} else {
    console.error('JWT_SECRET is not set in environment variables');
}
// {/fact}
