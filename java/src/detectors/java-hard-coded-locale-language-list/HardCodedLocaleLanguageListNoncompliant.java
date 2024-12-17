// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-list@v1.0 defects=1}
import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import java.util.Set;

public class HardCodedLocaleLanguageListNoncompliant {

    // Noncompliant: Locale list is hard-coded, potentially limiting flexibility and causing maintenance issues.
    void nonCompliant() {
        Set<Locale> ALLOWED_LOCALES_INLINE = ImmutableSet.of(
                new Locale("ar", "AE"),
                new Locale("cs", "CZ")
        );
    }
}
// {/fact}
