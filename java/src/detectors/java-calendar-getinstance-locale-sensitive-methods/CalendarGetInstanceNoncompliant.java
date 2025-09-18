// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-calendar-getinstance-locale-sensitive-methods@v1.0 defects=1}
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarGetInstanceNoncompliant {
    // Noncompliant: Creates `Calendar` instance without specifying the Locale, potentially causing locale-sensitive issues.
    public void nonCompliant() {
        Locale myLocale = Locale.US;
        TimeZone timeZone = TimeZone.getTimeZone("Universal");
        Calendar cal = Calendar.getInstance(timeZone);
    }
}
// {/fact}
