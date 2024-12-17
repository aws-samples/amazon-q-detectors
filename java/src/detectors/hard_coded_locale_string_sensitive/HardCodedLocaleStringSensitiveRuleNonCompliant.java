// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-string-sensitive@v1.0 defects=1}
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HardCodedLocaleStringSensitiveRuleNonCompliant {

    public static final String TIMESTAMP_TEMPLATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    // Noncompliant: Hardcoded locale is used.
    public void nonCompliant() {
        String usLocale = "en_US";
        final DateFormat DATE_FORMAT = new SimpleDateFormat("MMMM d", Locale.of(usLocale));
        final String DATE = new SimpleDateFormat(TIMESTAMP_TEMPLATE, Locale.ROOT).format(new Date());
    }
}
// {/fact}
