// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-disable-html-auto-escape@v1.0 defects=0}
import markdownIt from 'markdown-it';

// Compliant: Disables raw HTML rendering for security
const markdown = markdownIt({
    html: false,
    linkify: true,
    typographer: true,
});
// {/fact}
