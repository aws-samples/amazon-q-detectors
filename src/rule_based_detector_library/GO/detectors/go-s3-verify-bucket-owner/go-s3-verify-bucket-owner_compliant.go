/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package go_s3_verify_bucket_owner

// {fact rule=go-s3-verify-bucket-owner@v1.0 defects=0}
import (
	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/s3"
	"log"
	"os"
)

func s3VerifyBucketOwnerCompliant() {
	fileName := "YOUR_PATH"
	sess, err := session.NewSession(&aws.Config{
		Region: aws.String("your-aws-region"),
	})
	if err != nil {
		log.Fatal("Error:", err)
		return
	}
	s3Client := s3.New(sess)
	file, err := os.Open(fileName)
	if err != nil {
		log.Printf("Couldn't open file %v to upload. Error: %v\n", fileName, err)
		return
	}
	defer file.Close()
	// Compliant: `ExpectedBucketOwner` is present.
	_, err = s3Client.PutObject(&s3.PutObjectInput{
		Bucket:              aws.String("your-bucket-name"),
		Key:                 aws.String("your-object-key"),
		Body:                file,
		ExpectedBucketOwner: aws.String("expected-bucket-owner-id"),
	})
	if err != nil {
		log.Printf("Couldn't upload file %v to %v:%v. Error: %v\n", fileName, "your-bucket-name", "your-object-key", err)
	}
}
// {/fact}
