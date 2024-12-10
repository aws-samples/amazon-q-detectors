// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-tainted-input-for-docker-api@v1.0 defects=1}
const {Docker} = require('node-docker-api');
var Dockerode = require('dockerode');

const express = require('express');
const app = express();


app.post('/create_container',  (req, res) => {
	var docker = new Dockerode('/var/run/docker.sock' );
	// Noncompliant: Passing an unsanitized user argument to a function call.
	docker.createContainer({Image: req.params.img, Cmd: ['/bin/bash'], name: req.params.name }, function (err, container) {
		container.start(function (err, data) {
				console.log("Container created");
		});
	});
});
// {/fact}
