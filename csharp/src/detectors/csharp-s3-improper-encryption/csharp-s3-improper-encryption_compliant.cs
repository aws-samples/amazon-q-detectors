// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-s3-improper-encryption@v1.0 defects=0}
using Amazon;
using Amazon.S3;
using Amazon.S3.Model;
using System;
using System.IO;

namespace S3UploadExample
{
    public class ConformantS3Upload
    {
        public void Compliant()
        {
            var s3Client = new AmazonS3Client();
            byte[] partData = new byte[1024];

            UploadPartRequest uploadPartRequest = new UploadPartRequest
            {
                BucketName = "your-bucket-name",
                Key = "your-object-key",
                UploadId = "your-upload-id",
                PartNumber = 1,
                PartSize = partData.Length,
                InputStream = new MemoryStream(partData)
            };

            // Compliant: UploadPart request includes the `key` parameter, ensuring proper object identification.
            UploadPartResponse uploadPartResponse = s3Client.UploadPart(uploadPartRequest);

            Console.WriteLine($"Part uploaded successfully. ETag: {uploadPartResponse.ETag}");
        }

        public static void Main()
        {
            ConformantS3Upload program = new ConformantS3Upload();
            program.Compliant();
        }
    }
}
//{/fact}