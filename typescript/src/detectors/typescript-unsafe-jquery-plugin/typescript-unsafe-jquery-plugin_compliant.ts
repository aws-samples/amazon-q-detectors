// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unsafe-jquery-plugin@v1.0 defects=0}
compliant = function(): void {
    let option: string = $("#selector").val() as string;
    // Compliant: User input is not passed as a selector to `jQuery`
    var source: JQuery = jQuery.find(option.sourceSelector);
    var text: string = source.text();
    jQuery(this).text(text);
}
// {/fact}
