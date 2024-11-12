// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-xpath-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import xpath from 'xpath';
import { DOMParser, dom } from 'xmldom';

const app = express();

function xpathInjectionCompliant() {
    app.get('www.example.com/:userName', (req: Request, res: Response) => {
        var userName = req.params.userName;
        var xml = "<book><title>Harry Potter</title></book>";
        var doc = new dom().parseFromString(xml);
        // Compliant: Passing sanitized user-input in an XPath expression.
        var nodes = xpath.select("//title" + escape(userName), doc);
    });
}
// {/fact}
