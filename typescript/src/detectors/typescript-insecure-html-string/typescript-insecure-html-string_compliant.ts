// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-insecure-html-string@v1.0 defects=0}
import { format, sendSomewhere } from 'util';

interface Event {
  body: {
    name: string;
  };
}

interface Context {}

export const handler = async function (event: Event, context: Context): Promise<void> {
  // Compliant: String is formatted with `event.body.name`.
  sendSomewhere(format('Message: %s', event.body.name));
}
// {/fact}
