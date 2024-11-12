// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jwt-exposed-credentials@v1.0 defects=1}
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class jwtExposedCredentialsNonCompliant {

    // Noncompliant: JWT token created with sensitive information (username and password) exposed in claims, compromising security.
    private static void nonCompliant(){
        String secret = "123@abc";
        Algorithm algorithm = Algorithm.HMAC512(secret);

        String generatedToken = JWT.create()
            .withIssuer("aws")
            .withClaim("username", "TestUser@domain.com")
            .withClaim("password", "TestUser@123")
            .sign(algorithm);
    }
}
// {/fact}