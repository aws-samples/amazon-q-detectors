// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-log-confidential-information@v1.0 defects=0}
import { Signale } from 'signale';

function loggingOfSensitiveInformationCompliant() {
    var options = {
        disabled: false,
        interactive: false,
        logLevel: 'info',
        scope: 'custom',
        // Compliant: Pattern for `secrets` is configured and hence will not be logged.
        secrets: ["[1-9]{10}"]
    };
    const info = "ss";
    const logger = new Signale(options);
    logger.log('Secret is: ', info);
}
// {/fact}
