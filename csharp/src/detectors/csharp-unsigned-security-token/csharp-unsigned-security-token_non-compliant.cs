// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unsigned-security-token@v1.0 defects=1}
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.IdentityModel.Tokens;

namespace JwtConfigurationExample
{
    public class NonConformantJwtConfiguration
    {
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
            {
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    // Noncompliant: Allows unsigned tokens, potentially compromising security by accepting tampered tokens.
                    RequireSignedTokens = false,
                    ValidateIssuer = false,
                    ValidateAudience = false
                };
            });

        }

        public static void Main()
        {
            var services = new ServiceCollection();
            var example = new NonConformantJwtConfiguration();
            example.ConfigureServices(services);

            var serviceProvider = services.BuildServiceProvider();
        }
    }
}
//{/fact}