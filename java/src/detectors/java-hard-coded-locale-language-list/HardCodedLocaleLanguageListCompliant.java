// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-list@v1.0 defects=0}
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class HardCodedLocaleLanguageListCompliant {

    // Compliant: Locale list is dynamically generated from environment variables, avoiding hard-coded values.
    void compliant() {
        Set<Locale> ALLOWED_LOCALES = getAllowedLocalesFromEnv();
    }

    private Set<Locale> getAllowedLocalesFromEnv() {
        String localesEnv = System.getenv("ALLOWED_LOCALES");
        if (localesEnv == null || localesEnv.isEmpty()) {
            throw new IllegalStateException("ALLOWED_LOCALES not set");
        }

        return Arrays.stream(localesEnv.split(","))
                .map(s -> {
                    String[] parts = s.trim().split("_");
                    return new Locale(parts[0], parts[1]);
                })
                .collect(Collectors.toSet());
    }
}
// {/fact}
