// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-ami-describe-images@v1.0 defects=1}
const AWS = require('aws-sdk')

function nonCompliant() {
    const ec2 = new AWS.EC2()

    let params = {
        Filters: [
            {
                // Noncompliant: Requests Amazon Machine Images (AMIs) with only name filter ignoring owner or AMI identifiers.
                Name: 'name',
                Values: [
                    'The name of the AMI (provided during image creation)', 'image-2'
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
