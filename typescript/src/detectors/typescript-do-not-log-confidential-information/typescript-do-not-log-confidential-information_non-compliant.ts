// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-log-confidential-information@v1.0 defects=1}
import { Signale } from 'signale';

function loggingOfSensitiveInformationNoncompliant() {
    var options = {
        disabled: false,
        interactive: false,
        logLevel: 'info',
        scope: 'custom',
        // Noncompliant: Empty `secrets` list allows sensitive information to be logged, potentially exposing confidential data.
        secrets: []
    };
    const info ="s";
    const logger = new Signale(options);
    logger.log('Secret is: ', info);
}
// {/fact}
