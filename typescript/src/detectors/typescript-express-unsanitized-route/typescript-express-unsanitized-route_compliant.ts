// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-unsanitized-route@v1.0 defects=0}
import { Request, Response } from 'express';

function compliant(): void {
    app.route('/user/:id')
        .get((req: Request, res: Response): void => {
            // Compliant: User input is sanitized before use.
            let id_: string = escape(req.params.id);
            let str1: string = id_ + `
        <form method="POST" style="margin: 60px auto; width: 140px;">
            <p><input name="username" type="text" /></p>
            <p><input name="password" type="password" /></p>
            <p><input value="Login" type="submit" /></p>
        </form>
        `;
            res.send(str1);
        });
}

// {/fact}
