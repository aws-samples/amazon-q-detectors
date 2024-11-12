// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-limit-on-request-content-length@v1.0 defects=1}
import express from 'express';
import bodyParser from 'body-parser';

const app = express();

function limitOnRequestContentLengthNoncompliant() {
    // Noncompliant: Request content length `limit` exceeds `2mb`, increasing risk of memory exhaustion attacks.
    app.use(bodyParser.urlencoded({ extended: false, limit: "4mb" }));
}
// {/fact}
