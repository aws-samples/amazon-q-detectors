// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package aws

// {fact rule=go-aws-unchecked-batch-failures@v1.0 defects=0}
import (
	"context"
	"fmt"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/sns"
)

func awsUncheckedBatchFailuresCompliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	output, err := client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})

	// Compliant: Batch operation is performed with error handling.
	if err != nil {
		fmt.Println("Error publishing batch:", err)
		return
	}

	fmt.Println(output)
}
// {/fact}
