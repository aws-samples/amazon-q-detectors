// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-vm-runincontext-injection@v1.0 defects=0}
var express = require('express')
var app = express()
var vm = require('vm')

function compliant() {
    app.get('/perform/:action', (req, res) => {
        const sandbox = {
            actionToPerform: req.params.action
        }
        const code = 'performAction(sandbox.actionToPerform)'
        vm.createContext(sandbox)
        // Compliant: User-supplied parameter must be in allow-list to be evaluated.
        if(sandbox.actionToPerform.match(/^pull|fetch|add|commit$/)) {
            vm.runInContext(code, sandbox)
            res.send('Action performed successfully!')
        }
        else
            res.send('Invalid action')
    })
}
// {/fact}
