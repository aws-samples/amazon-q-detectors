// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-tainted-input-for-docker-api@v1.0 defects=0}
const {Docker} = require('node-docker-api');
var Dockerode = require('dockerode');

const express = require('express');
const app = express();

function compliant(){
    app.post('/create_container',  (req, res) => {
        var docker = new Dockerode({socketPath: '/var/run/docker.sock'});
        // Compliant: Passing a predetermined user argument to a function call.
        docker.createContainer({Image: 'ubuntu', Cmd: ['/bin/bash'], name: 'ubuntu-test'}, function (err, container) {
            container.start(function (err, data) {
                console.log("Container created");
            });
        });
    })
}
// {/fact}
