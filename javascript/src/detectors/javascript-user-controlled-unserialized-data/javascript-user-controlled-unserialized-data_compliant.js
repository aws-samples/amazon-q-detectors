// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-user-controlled-unserialized-data@v1.0 defects=0}
const express = require( "express" );
const serialize = require( "node-serialize" );
const app = express();
const createTable = require( "./createTable" );

app.get( "/getdata", function ( req, res ){
    var data = req.body.obj;
    var c = "";
    if(data.myobj === c){
        return;
    }
    // Compliant: Basic validation is present before using user input in `unserialize()`.
    createTable( serialize.unserialize( c ), res );
} );
// {/fact}
