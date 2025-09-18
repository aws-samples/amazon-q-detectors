// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-split@v1.0 defects=0}
import java.util.Locale;

public class HardCodedLocaleLanguageSplitRuleCompliant {

    // Compliant: Instead of manually splitting locale, locale native method used to derive information.
    public void compliant(Locale locale) {
        Locale locale = new Locale("en", "US");
        String language = locale.getLanguage();
        String country = locale.getCountry();
    }
}
// {/fact}
