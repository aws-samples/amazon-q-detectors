// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-deprecated-get-configuration@v1.0 defects=0}
using Amazon.AppConfig;
using Amazon.AppConfig.Model;

namespace AppConfigExample.Compliant
{
    public class Program
    {
        public static async Task Main(string[] args)
        {
            var client = new AmazonAppConfigClient();
            
            var request = new GetHostedConfigurationVersionRequest
            { 
                ApplicationId = "app123",
                ConfigurationProfileId = "conf456",
                VersionNumber = 1
            };

            // Compliant: Uses `GetHostedConfigurationVersion` API which is the recommended way to retrieve configurations.
            var response = await client.GetHostedConfigurationVersionAsync(request);
            Console.WriteLine($"Configuration retrieved successfully using recommended approach.");
        }
    }
}
// {/fact}