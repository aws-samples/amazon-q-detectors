// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-ajv-allerrors-true@v1.0 defects=0}
import Ajv from 'ajv';

function compliant(): void {
    // Compliant: `allErrors` is not explicitly set to `true`.
    const ajv = new Ajv({ allErrors: process.env.DEBUG === 'true' }); 
    ajv.addSchema(schema, 'input');
}
// {/fact}