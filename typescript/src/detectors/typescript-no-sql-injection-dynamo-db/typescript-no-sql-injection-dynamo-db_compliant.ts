// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-no-sql-injection-dynamo-db@v1.0 defects=0}
import express, { Request, Response } from 'express';
import AWS from 'aws-sdk';

const app = express();

function noSqlInjectionCompliant() {
    app.get('/api/getallusers', function (req: Request, res: Response) {
        var docClient = new AWS.DynamoDB.DocumentClient({ region: "us-east-1" });
        var params = {
            TableName: "dynamodb-example-node",
            ProjectionExpression: "user_id, username, user_age",
        };
        // Compliant: Should not use external input in `scan` API.
        docClient.scan(params, (err: AWS.AWSError | null, data: AWS.DynamoDB.DocumentClient.ItemList) => {
            if (err) {
                console.log(err);
            } else {
                res.status(200).json({ "status": 1, "message": "user exists", "data": data });
            }
        });
    });
}
// {/fact}
