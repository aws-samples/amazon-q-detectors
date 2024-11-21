// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-vm-runincontext-injection@v1.0 defects=1}
var express = require('express')
var app = express()
var vm = require('vm')
function noncompliant() {
    app.get('/perform/:action', (req, res) => {
        const sandbox = {
            actionToPerform: req.params.action
        }
        const code = 'performAction(sandbox.actionToPerform)'
        vm.createContext(sandbox)
        // Noncompliant: User-supplied input evaluated as a script.
        vm.runInContext(code, sandbox)
        res.send('Action performed successfully!')
    })
}
// {/fact}
