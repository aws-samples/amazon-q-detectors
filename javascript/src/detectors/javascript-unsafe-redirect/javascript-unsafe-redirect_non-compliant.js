// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-redirect@v1.0 defects=1}
const express= require('express')
const csrf = require('csurf');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());
app.use(csrf());

function nonCompliant(){
    app.use(json());
    app.get('/unsafe',function(req,res){
        let data= req.params;
        let url= data.url;
        // Noncompliant: Direct use of user-provided URL in `res.location()` without validation enables open redirect vulnerabilities.
        res.location(url);
    })
}
// {/fact}
