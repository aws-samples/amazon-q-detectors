// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-permissive-cors-configuration@v1.0 defects=1}
import java.util.regex.Pattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PermissiveCORSConfigurationRuleNonCompliant {
    private static final Pattern ALLOWED_CORS_ORIGIN_EXPR_POSITIVE_2 = Pattern.compile(".*");

    @Bean
    @Scope("singleton")
    // Noncompliant: ALLOWED_CORS_ORIGIN_EXPR_POSITIVE_2 compiles a pattern for * which would match everything.
    public CrossOriginHandler nonCompliant() {
        CrossOriginHandler handler = new CrossOriginHandler();
        handler.setAllowCredentials(true);
        handler.setOriginValidator(
                new CrossOriginHandler.OriginPatternValidator(ALLOWED_CORS_ORIGIN_EXPR_POSITIVE_2));
        return handler;
    }

    public static class CrossOriginHandler {
        private boolean allowCredentials;
        private OriginPatternValidator originValidator;

        public void setAllowCredentials(boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }

        public void setOriginValidator(OriginPatternValidator originValidator) {
            this.originValidator = originValidator;
        }

        public boolean isAllowCredentials() {
            return allowCredentials;
        }

        public OriginPatternValidator getOriginValidator() {
            return originValidator;
        }

        public static class OriginPatternValidator {
            private final Pattern pattern;

            public OriginPatternValidator(Pattern pattern) {
                this.pattern = pattern;
            }

            public boolean isValid(String origin) {
                return pattern.matcher(origin).matches();
            }
        }
    }
}
// {/fact}