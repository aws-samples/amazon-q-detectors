// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-vm-runincontext-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import vm from 'vm';

const app = express();

function codeInjectionNoncompliant(): void {
    app.get('/perform/:action', (req: Request, res: Response) => {
        const sandbox = {
            actionToPerform: req.params.action
        };
        const code = 'performAction(sandbox.actionToPerform)';
        vm.createContext(sandbox);
        // Noncompliant: User-supplied input evaluated as a script.
        vm.runInContext(code, sandbox);
        res.send('Action performed successfully!');
    });
}
// {/fact}
