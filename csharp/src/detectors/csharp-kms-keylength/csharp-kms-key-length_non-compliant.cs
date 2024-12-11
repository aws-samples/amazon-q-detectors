// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-kms-key-length@v1.0 defects=1}
using Amazon.KeyManagementService;
using Amazon.KeyManagementService.Model;
namespace HelloWorld
{
    public class KmsKeyLengthExample
    {

        public void nonCompliant()
            {
                var kmsClient = new AmazonKeyManagementServiceClient();
                // Noncompliant: Using `AES_128` which is less secure than `AES_256`.
                var request = new GenerateDataKeyRequest
                {
                    KeyId = "your_key_id",
                    KeySpec = DataKeySpec.AES_128
                };

                var response = kmsClient.GenerateDataKey(request);
            }
    }
}
 //{/fact}