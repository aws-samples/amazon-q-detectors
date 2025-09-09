// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-tag@v1.0 defects=1}
import java.util.Locale;

public class HardCodedLocaleLanguageTagRuleNonCompliant {

    // Noncompliant: Hardcoding locale tag.
    public void nonCompliant() {
        Locale hardcodedLocale = Locale.forLanguageTag("en-US");
        processWithLocale(hardcodedLocale);
    }

    private void processWithLocale(Locale locale) {
        System.out.println("Processing with hardcoded locale: " + locale);
    }
}
// {/fact}
