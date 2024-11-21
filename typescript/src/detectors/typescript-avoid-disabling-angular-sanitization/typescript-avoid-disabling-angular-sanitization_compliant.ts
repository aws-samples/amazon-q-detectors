// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-disabling-angular-sanitization@v1.0 defects=0}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-something-compliant',
  template: '<div [innerHTML]="hello"></div>'
})
export class DisableAngularSanitizationCompliant implements OnInit {
  hello: SafeHtml;

  constructor(private route: ActivatedRoute, private sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    let name = this.route.snapshot.queryParams.name;
    let html = `<h1>Hey ${name}</h1>`;
    // Compliant: No sanitization bypass occurs.
    this.hello = this.sanitizer.sanitize(1, html);
  }
}
// {/fact}
