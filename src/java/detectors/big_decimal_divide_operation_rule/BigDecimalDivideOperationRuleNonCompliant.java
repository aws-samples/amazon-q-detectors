// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-big-decimal-divide-operation@v1.0 defect=1}
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDivideOperationRuleNonCompliant {

    private static final BigDecimal ONE_KILOBYTE = new BigDecimal(1024);

    // Noncompliant: BigDecimal divide operation used without specifying scale and rounding mode.
    public static void nonCompliant(long fileSizeBytes) {
        final BigDecimal fileSizeKB = new BigDecimal(fileSizeBytes)
                .divide(ONE_KILOBYTE);
    }
}
// {/fact}