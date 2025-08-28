// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-deprecated-get-configuration@v1.0 defects=0}
package main

import (
	"context"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/appconfigdata"
)

func compliant(appConfigDataClient *appconfigdata.Client) {
	// Compliant: Using recommended `GetLatestConfiguration()` API.
	res, err := appConfigDataClient.GetLatestConfiguration(context.Background(), &appconfigdata.GetLatestConfigurationInput{
		ConfigurationToken: aws.String("token-12345"),
	})
	
	if err != nil {
		panic(err)
	}
	
	_ = res
}
// {/fact}
