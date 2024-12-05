// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-jwt-tokenvalidationparameters-no-expiry@v1.0 defects=0}
using System;
using Microsoft.IdentityModel.Tokens;

namespace JwtTokenValidation.Compliant
{
    class TokenValidator
    {
        public static void Main(string[] args)
        {
            // Compliant: Requires token expiration time to ensure tokens are time-bound.
            TokenValidationParameters parameters = new TokenValidationParameters
            {
                RequireExpirationTime = true,
                ValidateAudience = false,
                ValidateIssuer = false
            };

            Console.WriteLine("Compliant TokenValidationParameters configured.");
        }
    }
}

// {/fact}
