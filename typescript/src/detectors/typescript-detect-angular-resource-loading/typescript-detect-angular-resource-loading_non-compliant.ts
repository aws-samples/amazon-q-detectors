// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-detect-angular-resource-loading@v1.0 defects=1}
import * as angular from 'angular';

const app = angular.module('MyApp', []).config(['$sceDelegateProvider', 
    function ($sceDelegateProvider: angular.ISCEDelegateProvider) {
        // Noncompliant: Using `$sceDelegateProvider` with wildcards can introduce security issues.
        $sceDelegateProvider.resourceUrlWhitelist(['**']);
    }
]);
// {/fact}
