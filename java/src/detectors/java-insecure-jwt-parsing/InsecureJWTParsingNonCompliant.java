// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-jwt-parsing@v1.0 defects=1}
import io.jsonwebtoken.Jwts;
import com.google.common.cache.LoadingCache;

public class InsecureJWTParsingNonCompliant {

    private LoadingCache<String, String> decryptedKeyCache;
    private KinesisAnalyticsAuthToken kinesisAnalyticsAuthToken;

    public void nonCompliant() {
        try {
            String plainTextSigningKey = decryptedKeyCache.getUnchecked(kinesisAnalyticsAuthToken.getSecret());
            // Noncompliant: Parsing an unsigned JSON web token (JWT) without throwing an error could result in downgrade attacks.
            Jwts.parser()
                    .setSigningKey(plainTextSigningKey)
                    .parse(kinesisAnalyticsAuthToken.getRawToken());
            System.out.println("JWT parsed successfully");
        } catch (Exception e) {
            System.err.println("Error parsing JWT: " + e.getMessage());
        }
    }

    private static class KinesisAnalyticsAuthToken {
        private String secret;
        private String rawToken;
        public KinesisAnalyticsAuthToken(String secret, String rawToken) {
            this.secret = secret;
            this.rawToken = rawToken;
        }
        public String getSecret() {
            return secret;
        }
        public String getRawToken() {
            return rawToken;
        }
    }
}
// {/fact}
