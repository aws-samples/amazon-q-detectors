// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jwt-none-algorithm@v1.0 defects=1}
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTNoneAlgorithmAuthNoncompliant {
    // Noncompliant: Uses the insecure `none` algorithm for JWT, which allows token forgery and bypasses signature verification.
    public static String nonCompliant(){
        Algorithm algorithm = Algorithm.none();

        String generatedToken = JWT.create()
            .withIssuer("AWS")
            .withClaim("username", "TestUser@domain.com")
            .withClaim("password", "TestUser@123")
            .sign(algorithm);
        return generatedToken;
    }

}
// {/fact}
