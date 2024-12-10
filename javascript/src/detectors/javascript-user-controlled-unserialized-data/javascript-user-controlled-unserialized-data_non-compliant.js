// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-user-controlled-unserialized-data@v1.0 defects=1}
const yaml = require('js-yaml');
const path = require('path');
const fs_extra = require('fs-extra');
const fs = require('fs');
const express = require( "express" );
const serialize = require( "node-serialize" );
const app = express();
const axios = require('axios');
const createTable = require( "./createTable" );

app.get( "/getdata", function ( req, res ){
    var data = req.body.obj
    // Noncompliant: tainted input is used in `unserialize()` or `yaml.load()`.
    createTable( serialize.unserialize( data ), res );
} );
// {/fact}
