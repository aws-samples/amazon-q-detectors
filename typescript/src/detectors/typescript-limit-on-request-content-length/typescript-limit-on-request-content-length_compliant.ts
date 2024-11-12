// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-limit-on-request-content-length@v1.0 defects=0}
import express from 'express';
import bodyParser from 'body-parser';

const app = express();

function limitOnRequestContentLengthCompliant() {
    // Compliant: Request content length `limit` is limited to less than `2mb` using body-parser to prevent memory exhaustion attacks.
    app.use(bodyParser.urlencoded({ extended: false, limit: "1mb" }));
}
// {/fact}
