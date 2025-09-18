// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-calendar-getinstance-locale-sensitive-methods@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
public class CalendarGetInstanceCompliant {
    Locale DEFAULT_LOCALE = Locale.getDefault();

    // Compliant: Creates `Calendar` instance with both TimeZone and Locale specified, avoiding locale-sensitive issues.
    public void compliant() {
        Locale myLocale = this.DEFAULT_LOCALE;
        TimeZone timeZone = TimeZone.getTimeZone("Universal");
        Calendar cal = Calendar.getInstance(timeZone, myLocale);
    }
}
// {/fact}
