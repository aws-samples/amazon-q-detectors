// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-insecure-grpc-connection@v1.0 defects=0}
function compliant() {
  // Compliant: GRPC client connection is created without explicitly specifying insecure credentials, defaulting to secure communication channel.
    var client = new hello_proto.Greeter('localhost:50051');
    var user;
    if (process.argv.length >= 3) {
      user = process.argv[2];
    } else {
      user = 'world';
    }
    client.sayHello({name: user}, function(err, response) {
      console.log('Greeting:', response.message);
    });
  }
// {/fact}
