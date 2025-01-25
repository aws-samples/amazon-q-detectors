// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unsafe-jquery-plugin@v1.0 defects=1}
const nonCompliant = function(): void {
    let options: string = $("#selector").val() as string;
    // Noncompliant: User input is being passed as a selector to `jQuery`.
    const source: JQuery<HTMLElement> = jQuery(options.sourceSelector);
    const text: string = source.text();
    jQuery(this).text(text);
}
// {/fact}
