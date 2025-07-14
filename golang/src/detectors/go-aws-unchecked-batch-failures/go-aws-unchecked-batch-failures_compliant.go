// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-aws-unchecked-batch-failures@v1.0 defects=0}
package main

import (
	"context"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/sns"
)

func compliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	output, err := client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})

	// Compliant: Batch operation errors are properly checked and handled.
	if err != nil {
		return
	}
	
	_ = output
}
// {/fact}
