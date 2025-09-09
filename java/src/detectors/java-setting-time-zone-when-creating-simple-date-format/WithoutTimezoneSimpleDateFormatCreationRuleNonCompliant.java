// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-setting-time-zone-when-creating-simple-date-format@v1.0 defects=1}
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithoutTimezoneSimpleDateFormatCreationRuleNonCompliant {

    // Noncompliant: Does not set the timezone while using a 'SimpleDateFormat' object.
    String nonCompliant() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
// {/fact}
