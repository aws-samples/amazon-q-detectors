// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-jwt-tokenvalidationparameters-no-expiry@v1.0 defects=1}
using Microsoft.IdentityModel.Tokens;
using System;

namespace JwtTokenValidation.NonCompliant
{
    class TokenValidator
    {
        public void ConfigureNonCompliantTokenValidation()
        {
            // Noncompliant: Does not require expiration time, making tokens vulnerable to indefinite use.
            TokenValidationParameters parameters = new TokenValidationParameters
            {
                RequireExpirationTime = false,
                ValidateAudience = false,
                ValidateIssuer = false
            };

            Console.WriteLine("Non-compliant TokenValidationParameters configured.");
        }
    }
}
// {/fact}
