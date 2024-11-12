// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-no-sql-injection-dynamo-db@v1.0 defects=1}
import express, { Request, Response } from 'express';
import AWS from 'aws-sdk';

const app = express();

function noSqlInjectionNoncompliant() {
    app.get('/api/getallusers', function (req: Request, res: Response) {
        var docClient = new AWS.DynamoDB.DocumentClient({ region: "us-east-1" });
        var params = req.body.params;
        // Noncompliant: External user input can be vulnerable to injection attacks.
        docClient.scan(params, (err: AWS.AWSError | null, data: AWS.DynamoDB.DocumentClient.ItemList) => {
            if (err) {
                console.log("Error", err);
            } else {
                data.Items.forEach((element: { Title: { S: string }; Subtitle: { S: string } }) => {
                    console.log(element.Title.S + " (" + element.Subtitle.S + ")");
                });
            }
        });
    });
}
// {/fact}
