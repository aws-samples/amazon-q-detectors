// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unsigned-security-token@v1.0 defects=0}
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.IdentityModel.Tokens;

namespace JwtConfigurationExample
{
    public class ConformantJwtConfiguration
    {
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
            {
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    // Compliant: Requires signed tokens, enhancing security by ensuring token integrity.
                    RequireSignedTokens = true,
                    ValidateIssuer = false,
                    ValidateAudience = false
                };
            });

        }

        public static void Main()
        {
            var services = new ServiceCollection();
            var example = new ConformantJwtConfiguration();
            example.ConfigureServices(services);
            var serviceProvider = services.BuildServiceProvider();
        }
    }
}
//{/fact}