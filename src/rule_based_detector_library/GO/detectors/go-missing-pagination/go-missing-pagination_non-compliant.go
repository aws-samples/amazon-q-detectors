/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pagination

// {fact rule=go-missing-pagination@v1.0 defects=1}
import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)

func missingPaginationNoncompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Printf("error: %v", err)
		return
	}

	client := s3.NewFromConfig(cfg)

	params := &s3.ListObjectsV2Input{
		Bucket: aws.String("my-bucket"),
	}

	// Noncompliant: Pagination is missing.
	output, err := client.ListObjectsV2(context.TODO(), params)
	if err != nil {
		log.Printf("error: %v", err)
	}
	fmt.Println(output)
}
// {/fact}
