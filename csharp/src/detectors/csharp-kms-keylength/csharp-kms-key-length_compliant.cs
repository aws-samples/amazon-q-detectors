 // Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-kms-key-length@v1.0 defects=0}
 using Amazon.KeyManagementService;
 using Amazon.KeyManagementService.Model;

 public class KmsKeyLengthExample
 {
     public void compliant()
        {
            var kmsClient = new AmazonKeyManagementServiceClient();
            // Compliant: Using `AES_256` for strong encryption.
            var request = new GenerateDataKeyRequest
            {
                KeyId = "your_key_id",
                KeySpec = DataKeySpec.AES_256
            };

            var response = kmsClient.GenerateDataKey(request);
        }
 }

 //{/fact}