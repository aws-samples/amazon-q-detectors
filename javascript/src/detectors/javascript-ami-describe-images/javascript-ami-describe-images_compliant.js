// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-ami-describe-images@v1.0 defects=0}
const AWS = require('aws-sdk')
const ec2 = new AWS.EC2()

function compliant() {
    let params = {
        Filters: [
            {
                // Compliant: Requests Amazon Machine Images (AMIs) with name and owner-id.
                Name: 'name',
                Values: [
                    'The name of the AMI (provided during image creation)',
                ]
            },
            {
                Name: 'owner-id',
                values: [
                    'The AWS account ID of the owner'
                ]
            },
            {
                Name: 'architecture',
                values: [
                    'x86_64'
                ]
            }
        ]
    }
    ec2.describeImages(params, function(err, data) {
        if (err) console.log(err, err.stack);
        else     console.log(data);
    });
}
// {/fact}
