// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-missing-pagination@v1.0 defects=0}
using Amazon.S3;
using Amazon.S3.Model;
using System;

namespace PaginationExample
{
    public class CompliantPagination
    {
        public void Compliant()
        {
            AmazonS3Client client = new AmazonS3Client();
            var request = new ListObjectsV2Request
            {
                BucketName = "paginators-example"
            };
           // Compliant: Properly implements pagination by using the continuation token.
            do
            {
                var response = client.ListObjectsV2(request);
                ProcessItems(response.S3Objects);
                request.ContinuationToken = response.NextContinuationToken;
            }
            while (response.IsTruncated);
        }

        private void ProcessItems(List<S3Object> s3Objects)
        {
            foreach (var obj in s3Objects)
            {
                Console.WriteLine($"Processing object: {obj.Key}");
            }
        }
    }
}
// {/fact}