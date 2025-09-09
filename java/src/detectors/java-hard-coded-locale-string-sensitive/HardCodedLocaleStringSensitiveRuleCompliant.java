// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-string-sensitive@v1.0 defects=0}
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HardCodedLocaleStringSensitiveRuleCompliant {

    public static final String TIMESTAMP_TEMPLATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    // Compliant: Locale is referred from an enum.
    public void compliant() {
        final DateFormat DATE_FORMAT = new SimpleDateFormat("MMMM d", Locale.ROOT);
        final String DATE = new SimpleDateFormat(TIMESTAMP_TEMPLATE, Locale.ROOT).format(new Date());
    }
}
// {/fact}
