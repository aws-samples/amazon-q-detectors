// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-date-time-pattern@v1.0 defects=1}
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimePatternNoncompliant {

    // Noncompliant: Uses a redundant and potentially confusing date-time pattern with repeated day, which could lead to parsing errors.
    public static DateTimeFormatter nonCompliant() {
        return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZyyyy-MM-dd'T'HH:mm:ss.SSSZ").withZoneUTC();
    }
}
// {/fact}
