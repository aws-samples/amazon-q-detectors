// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-vm-runincontext-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import vm from 'vm';

const app = express();

function codeInjectionCompliant(): void {
    app.get('/perform/:action', (req: Request, res: Response) => {
        const sandbox = {
            actionToPerform: req.params.action
        };
        const code = 'performAction(sandbox.actionToPerform)';
        vm.createContext(sandbox);
        // Compliant: User-supplied parameter must be in allow-list to be evaluated.
        if (sandbox.actionToPerform.match(/^pull|fetch|add|commit$/)) {
            vm.runInContext(code, sandbox);
            res.send('Action performed successfully!');
        } else {
            res.send('Invalid action');
        }
    });
}
// {/fact}
