// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package aws

// {fact rule=go-aws-unchecked-batch-failures@v1.0 defects=1}
import (
	"context"
	"fmt"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/sns"
)

func awsUncheckedBatchFailuresNoncompliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	// Noncompliant: Batch operation is performed without handling error.
	output, _ := client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})

	fmt.Println(output)
}
// {/fact}
