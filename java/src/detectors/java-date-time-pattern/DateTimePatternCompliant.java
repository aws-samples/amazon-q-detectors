// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-date-time-pattern@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Slf4j
public class DateTimePatternCompliant {

    // Compliant: Uses a standard `ISO 8601` date-time pattern with timezone, ensuring consistent and unambiguous datetime representation.
    public static DateTimeFormatter compliant() {
        return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withZoneUTC();
    }
}
// {/fact}
