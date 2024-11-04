/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package lambda_client

// {fact rule=go-lambda-client-reuse@v1.0 defects=0}
import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)

var cfg, err = config.LoadDefaultConfig(context.TODO())
var s3Client = s3.NewFromConfig(cfg)

func LambdaHandlerCompliant(ctx context.Context) (string, error) {
	// Compliant: Reused S3 client.
	result, err := s3Client.ListBuckets(ctx, &s3.ListBucketsInput{})
	if err != nil {
		log.Fatalf("Error listing buckets: %v", err)
	}

	var bucketNames []string
	for _, bucket := range result.Buckets {
		if bucket.Name != nil {
			bucketNames = append(bucketNames, *bucket.Name)
		}
	}

	message := fmt.Sprintf("S3 Buckets: %v", bucketNames)
	return message, nil
}
// {/fact}
