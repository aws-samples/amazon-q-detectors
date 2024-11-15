// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jwt-none-algorithm@v1.0 defects=0}
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTNoneAlgorithmAuthCompliant {
    // Compliant: Uses a secure HMAC256 algorithm for JWT signing, ensuring token integrity and authenticity.
    public static String compliant(){
        Algorithm algorithm = Algorithm.HMAC256("secret");

        String generatedToken = JWT.create()
            .withIssuer("AWS")
            .withClaim("username", "TestUser@domain.com")
            .withClaim("password", "TestUser@123")
            .sign(algorithm);

        return generatedToken;
    }
}
// {/fact}