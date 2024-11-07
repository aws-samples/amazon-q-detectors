// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package not_recommended_api

// {fact rule=go-not-recommended-apis@v1.0 defects=1}
import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)


func notRecommendedApisNoncompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Fatal("Unable to load SDK config, ", err)
	}

	client := s3.NewFromConfig(cfg)

	// Noncompliant: `ListObjects` is not recommended to use.
	respD, errD := client.ListObjects(context.TODO(), &s3.ListObjectsInput{Bucket: aws.String("your-bucket-name")})

	if errD != nil {
		log.Fatal("Error:", errD)
	}
	fmt.Println(respD)
}
// {/fact}
