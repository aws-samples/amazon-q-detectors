// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-permissive-cors-configuration@v1.0 defect=0}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import java.util.regex.Pattern;

public class PermissiveCORSConfigurationRuleCompliant {
    private static final Pattern ALLOWED_CORS_ORIGIN_EXPR = Pattern.compile("^https://sub.amazon.com$");

    @Bean
    @Scope("singleton")
    // Compliant: Using a trusted CORS origin
    public CrossOriginHandler compliant() {
        CrossOriginHandler handler = new CrossOriginHandler();
        handler.setAllowCredentials(true);
        handler.setOriginValidator(
                new CrossOriginHandler.OriginPatternValidator(ALLOWED_CORS_ORIGIN_EXPR));
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