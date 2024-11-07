// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-improper-authentication@v1.0 defects=0}
using System;
using System.IdentityModel.Tokens.Jwt;
using System.Text;
using Microsoft.IdentityModel.Tokens;

namespace Authentication.Compliant
{
    class ImproperAuthentication
    {
        public void ValidateTokenCompliant(string token)
        {
            var mySecret = "asdv234234^&%&^%&^hjsdfb2%%%";
            var mySecurityKey = new SymmetricSecurityKey(Encoding.ASCII.GetBytes(mySecret));
            var myIssuer = "http://mysite.com";
            var myAudience = "http://myaudience.com";
            var tokenHandler = new JwtSecurityTokenHandler();
            // Compliant: `JwtSecurityTokenHandler` is validating before using it.
            tokenHandler.ValidateToken(token, new TokenValidationParameters
            {
                ValidateIssuerSigningKey = true,
                ValidateIssuer = true,
                ValidateAudience = true,
                ValidIssuer = myIssuer,
                ValidAudience = myAudience,
                IssuerSigningKey = mySecurityKey
            }, out SecurityToken validatedToken);
        }

        public static void Main(string[] args)
        {
            Console.WriteLine("Running Compliant Authentication Test");
            ImproperAuthentication auth = new ImproperAuthentication();
            string sampleToken = "your_sample_jwt_token"; 
            auth.ValidateTokenCompliant(sampleToken);

            Console.WriteLine("Completed Authentication Test");
        }
    }
}
// {/fact}