// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-detect-angular-resource-loading@v1.0 defects=0}
import * as angular from 'angular';

const app = angular.module('MyApp', []).config(['$sceDelegateProvider', 
    function ($sceDelegateProvider: angular.ISCEDelegateProvider) {
        // Compliant: Using `$sceDelegateProvider` without wildcards help prevent security issues.
        $sceDelegateProvider.resourceUrlWhitelist(['Enter specific trusted URL here']);
    }
]);
// {/fact}