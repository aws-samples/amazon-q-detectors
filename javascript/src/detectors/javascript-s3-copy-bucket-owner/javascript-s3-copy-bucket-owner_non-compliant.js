// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-s3-copy-bucket-owner@v1.0 defects=1}
const AWS = require('aws-sdk');
const s3 = new AWS.S3();

var params = {
    Bucket: "destinationbucket",
    CopySource: "/sourcebucket/HappyFacejpg",
    Key: "HappyFaceCopyjpg"
};

// Noncompliant: `ExpectedBucketOwner` and `ExpectedSourceBucketOwner` properties have not been set which could make you interact with the incorrect bucket.
s3.copyObject(params, function(err, data) {
    if (err) {
        console.log("Error:", err, err.stack);
    } else {
        console.log("Success:", data);
    }
});
// {/fact}
