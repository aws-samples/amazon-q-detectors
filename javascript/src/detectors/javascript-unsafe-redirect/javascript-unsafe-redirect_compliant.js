// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-redirect@v1.0 defects=0}
const express= require('express')
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
var validUrl = require('valid-url');

const app = express();

app.use(cookieParser());
app.use(csrf());

app.get('/safe',function(req,res){
    let url= req.params.url
    if(validUrl.isUri(url)){
        // Compliant: URL validation using `validUrl.isUri()` before redirection prevents open redirect vulnerabilities and ensures safe URL handling.
        return res.location(url)
    }
    return res.location('/')
});
// {/fact}
