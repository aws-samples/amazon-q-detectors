// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-insecure-grpc-connection@v1.0 defects=1}
var grpc = require('grpc');

function nonCompliant() {
  // Noncompliant: Using `grpc.credentials.createInsecure()` creates unencrypted gRPC connections, exposing data to potential tampering and eavesdropping.
  var client = new hello_proto.Greeter('localhost:50051',
                                       grpc.credentials.createInsecure());
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
