// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-deprecated-get-configuration@v1.0 defects=1}
using Amazon.AppConfig;
using Amazon.AppConfig.Model;

namespace AppConfigExample.NonCompliant
{
    public class Program
    {
        public static async Task GetConfigurationExample()
        {
            var client = new AmazonAppConfigClient();
            
            var request = new GetConfigurationRequest 
            { 
                Application = "example-application",
                ClientId = "example-id",
                Configuration = "Example-Configuration-Profile",
                Environment = "Example-Environment"
            };

            // Noncompliant: Uses deprecated `GetConfiguration` API which has been replaced by newer configuration retrieval methods.
            var response = await client.GetConfigurationAsync(request);
            Console.WriteLine($"Configuration retrieved using deprecated approach.");
        }
    }
}
// {/fact}