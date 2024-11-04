/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pagination

// {fact rule=go-missing-pagination@v1.0 defects=0}
import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)

func missingPaginationCompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Printf("error: %v", err)
		return
	}

	client := s3.NewFromConfig(cfg)

	params := &s3.ListObjectsV2Input{
		Bucket: aws.String("my-bucket"),
	}

	// Compliant: `NewListObjectsV2Paginator` is used.
	paginator := s3.NewListObjectsV2Paginator(client, params, func(o *s3.ListObjectsV2PaginatorOptions) {
		o.Limit = 10
	})

	for paginator.HasMorePages() {
		output, err := paginator.NextPage(context.TODO())
		if err != nil {
			log.Printf("error: %v", err)
			return
		}
		fmt.Println(output)
	}
}
// {/fact}
