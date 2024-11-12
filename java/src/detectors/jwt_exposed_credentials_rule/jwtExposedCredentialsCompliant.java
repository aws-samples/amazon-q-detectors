// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jwt-exposed-credentials@v1.0 defects=0}
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.HashMap;
import java.util.Map;

public class jwtExposedCredentialsCompliant {

    // Compliant: JWT token created with sensitive information (password) retrieved from system property.
    private static void compliant(){
        String secret = "123@abc";
        Algorithm algorithm = Algorithm.HMAC512(secret);

        Map<String,String> payload = new HashMap();
        payload.put("name","John");
        payload.put("phone","022-123654");
        payload.put("password", System.getProperty("PWD"));

        String generatedToken = JWT.create()
            .withPayload(payload)
            .sign(algorithm);
    }
}
// {/fact}