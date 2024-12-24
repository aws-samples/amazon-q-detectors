// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-server-side-template-injection@v1.0 defects=1}
import * as handlebars from 'handlebars';
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app = express();
app.use(cookieParser());

interface TemplateRequest extends Request {
    query: {
        foo?: string;
    };
}

// Noncompliant: Directly compiles untrusted user input with Handlebars, leading to potential server-side template injection.
app.get('/', function(request: TemplateRequest, response: Response) {
    if (request.query.foo) {
        handlebars.compile(request.query.foo);
    }
});
// {/fact}
