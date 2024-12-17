// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-setting-time-zone-when-creating-simple-date-format@v1.0 defects=0}
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WithoutTimezoneSimpleDateFormatCreationRuleCompliant {

    // Compliant: TimeZone is set while using `SimpleDateFormat`.
    String compliant() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }
}
// {/fact}
