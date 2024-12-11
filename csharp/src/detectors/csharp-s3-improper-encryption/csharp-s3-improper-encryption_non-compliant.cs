// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-s3-improper-encryption@v1.0 defects=1}
using Amazon;
using Amazon.S3;
using Amazon.S3.Model;
using System;
using System.IO;

namespace S3UploadExample
{
    public class NonConformantS3Upload
    {
        public void NonCompliant()
        {
            var s3Client = new AmazonS3Client();
            byte[] partData = new byte[1024];

            UploadPartRequest uploadPartRequest = new UploadPartRequest
            {
                BucketName = "your-bucket-name",
                UploadId = "your-upload-id",
                PartNumber = 1,
                PartSize = partData.Length,
                InputStream = new MemoryStream(partData)
            };

            // Noncompliant: UploadPart request is missing the `key` parameter, which can lead to improper object identification.
            UploadPartResponse uploadPartResponse = s3Client.UploadPart(uploadPartRequest);

            Console.WriteLine($"Part uploaded successfully. ETag: {uploadPartResponse.ETag}");
        }

        public static void Main()
        {
            NonConformantS3Upload program = new NonConformantS3Upload();
            program.NonCompliant();
        }
    }
}
//{/fact}