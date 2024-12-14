// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-log-aws-credentials@v1.0 defects=1}
var AWS = require('aws-sdk');
var log = require('npmlog');
var log4js = require("log4js");
var logger = log4js.getLogger();
var os = require('os');


function nonCompliant(){
    var sts_client = new AWS.STS();
    var assumed_role_object=sts_client.assumeRole({
        RoleArn:"arn:aws:iam::account-of-role-to-assume:role/name-of-role",
        RoleSessionName:"AssumeRoleSession1"
    })
    var credentials = assumed_role_object['Credentials'];
    // Noncompliant: Encrypted AWS credentials are logged.
    log.info(credentials['SecretAccessKey'])
}
// {/fact}
