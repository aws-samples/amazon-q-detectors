// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-aws-unchecked-batch-failures@v1.0 defects=1}
package main

import (
	"context"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/sns"
)

func noncompliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	// Noncompliant: Batch operation failures are not checked or handled.
	client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})
}
// {/fact}
