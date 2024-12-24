// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-no-sql-injection-dynamo-db@v1.0 defects=1}
const AWS = require('aws-sdk');
const express = require("express");
const app = express();



app.get('/aws/getAllUsers', function(req, res) {
    var dobClient = new AWS.DynamoDB({apiVersion: '2012-08-10'});
    var params= req.body.params;
    params.ExclusiveStartKey = null;
    const allItems = [];

    // Noncompliant: DynamoDB service APIs `query` or `scan` is using user-provided data.
    do {
        dobClient.query(params, function (err, data) {
            if (err) {
                console.log("Error", err);
            } else {
                params.ExclusiveStartKey = data.LastEvaluatedKey;
                allItems.push(...data.Items);
            }
        });
    } while( params.ExclusiveStartKey )
    res.send(allItems);
})
// {/fact}
