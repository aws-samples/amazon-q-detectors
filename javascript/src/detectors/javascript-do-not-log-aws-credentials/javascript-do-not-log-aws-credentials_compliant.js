// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-log-aws-credentials@v1.0 defects=0}
function compliant(){
    var credentials = new AWS.Credentials();
    // Compliant: Encrypted AWS credentials are logged.
    console.log(credentials);
}
// {/fact}
