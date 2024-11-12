// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-xpath-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import xpath from 'xpath';
import { DOMParser, dom } from 'xmldom';

const app = express();

function xpathInjectionNoncompliant() {
    app.get('www.example.com/:userName', (req: Request, res: Response) => {
        var userName = req.params.userName;
        var xml = "<book><title>Harry Potter</title></book>";
        var doc = new dom().parseFromString(xml);
        // Noncompliant: Passing user-input directly in an XPath expression.
        var nodes = xpath.select("//title" + userName, doc);
    });
}
// {/fact}
