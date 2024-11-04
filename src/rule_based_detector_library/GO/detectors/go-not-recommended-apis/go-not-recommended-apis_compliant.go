/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package not_recommended_api

// {fact rule=go-not-recommended-apis@v1.0 defects=0}
import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)

func notRecommendedApisCompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Fatal("Unable to load SDK config, ", err)
	}

	client := s3.NewFromConfig(cfg)

	// Compliant: `ListObjectsV2Paginator` is used instead of `ListObjects`.
	paginator := s3.NewListObjectsV2Paginator(client,
		&s3.ListObjectsV2Input{
			Bucket: aws.String("your-bucket-name"),
		},
		func(o *s3.ListObjectsV2PaginatorOptions) {
			o.Limit = 10
		})

	for paginator.HasMorePages() {
		respD, errD := paginator.NextPage(context.TODO())
		if errD != nil {
			log.Printf("error: %v", err)
			return
		}
		fmt.Println(respD)
	}
}
// {/fact}
