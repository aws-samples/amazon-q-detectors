// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-deprecated-get-configuration@v1.0 defects=1}
package main

import (
	"context"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/appconfig"
)

func noncompliant(appConfigClient *appconfig.Client) {
	// Noncompliant: Using deprecated `GetConfiguration()` API with all required parameters.
	res, err := appConfigClient.GetConfiguration(context.Background(), &appconfig.GetConfigurationInput{
		Application:                aws.String("myApp"),
		Configuration:              aws.String("myConfig"),
		ClientId:                   aws.String("client-12345"),
		Environment:                aws.String("production"),
		ClientConfigurationVersion: aws.String("v1"),
	})
	
	if err != nil {
		panic(err)
	}
	
	_ = res
}
// {/fact}
