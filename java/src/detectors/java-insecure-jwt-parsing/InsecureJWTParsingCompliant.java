// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-jwt-parsing@v1.0 defects=0}
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import com.google.common.cache.LoadingCache;
import java.security.Key;
import java.nio.charset.StandardCharsets;

public class InsecureJWTParsingCompliant {
    private LoadingCache<String, String> decryptedKeyCache;
    private KinesisAnalyticsAuthToken kinesisAnalyticsAuthToken;
    public void compliant() {
        try {
            String plainTextSigningKey = decryptedKeyCache.getUnchecked(kinesisAnalyticsAuthToken.getSecret());
            Key key = Keys.hmacShaKeyFor(plainTextSigningKey.getBytes(StandardCharsets.UTF_8));
            // Compliant: Using the `parseClaimsJws` method helps prevent downgrade attacks.
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(kinesisAnalyticsAuthToken.getRawToken());
            System.out.println("JWT verified successfully");
        } catch (Exception e) {
            System.err.println("Error verifying JWT: " + e.getMessage());
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
