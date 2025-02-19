// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-disable-html-auto-escape@v1.0 defects=1}
import * as kramed from 'kramed';

function nonCompliant(): void {
    const options = {
        // Noncompliant: Disabling the `sanitize` option allows potentially dangerous HTML content to be rendered.
        renderer: new kramed.Renderer({
            sanitize: false
        })
    };
}
// {/fact}
