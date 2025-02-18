// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-insecure-html-string@v1.0 defects=1}
import { format, sendSomewhere } from 'util';

interface Event {
    name: string;
}

interface Context {}

export const handler = async function (event: Event, context: Context): Promise<void> {
    // Noncompliant: `event.name` is passed through to a HTML tag.
    await sendSomewhere(`<h1>message: ${event.name}</h1>`);
}
// {/fact}
