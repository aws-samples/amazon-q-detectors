// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-no-sql-injection-dynamo-db@v1.0 defects=0}
const AWS = require('aws-sdk');
const express = require("express");
const app = express();

app.get('/api/getAllUsers', function (req, res){
    var dobClient = new AWS.DynamoDB({apiVersion: '2012-08-10'});
    var params = {
      TableName: "dynamodb-example-node",
      ProjectionExpression: "user_id, username, user_age",
    };
    params.ExclausiveStartKey = null;
    const allItems = [];

    // Compliant: DynamoDB service APIs `query` or `scan` is uses predefined data.
    do {
        dobClient.scan(params, function (err, data) {
            if (err) {
                console.log(err);
            } else {
                params.ExclusiveStartKey = data.LastEvaluatedKey;
                allItems.push(...data.Items);
            }
        });
    } while (params.ExclusiveStartKey)
    res.send(allItems);
});
// {/fact}
