// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-construct-regular-expression-from-user-input@v1.0 defects=0}
import escapeStringRegexp from 'escape-string-regexp';
import fetch from 'node-fetch';

function conformant()
{
    fetch("some link")
        // Compliant: Creating RegExp from validated user input. 
        .then(res => res.json())
        .then((data:string) => RegExp(escapeStringRegexp(data)))
        .catch((error) => {
            console.error("Error in function:", error);
        });
}
// {/fact}
