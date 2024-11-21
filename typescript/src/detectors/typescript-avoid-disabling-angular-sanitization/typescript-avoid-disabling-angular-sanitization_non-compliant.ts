// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-disabling-angular-sanitization@v1.0 defects=1}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-something-noncompliant',
  template: '<div [innerHTML]="hello"></div>'
})
export class DisableAngularSanitizationNoncompliant implements OnInit {
  hello: any;

  constructor(private route: ActivatedRoute, private sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    let name = this.route.snapshot.queryParams.name;
    let html = "<h1>Hey " + name + "</h1>";
    // Noncompliant: `bypassSecurityTrustHtml` is used.
    this.hello = this.sanitizer.bypassSecurityTrustHtml(html);
  }
}
// {/fact}
