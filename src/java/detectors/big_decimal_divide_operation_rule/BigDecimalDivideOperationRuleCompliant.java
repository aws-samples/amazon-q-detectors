// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-big-decimal-divide-operation@v1.0 defect=0}
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDivideOperationRuleCompliant {
    private static final BigDecimal ONE_KILOBYTE = new BigDecimal(1024);

    // Compliant: `BigDecimal` divide operation used with specified RoundingMode.
    public static void compliant(long fileSizeBytes) {
        final BigDecimal fileSizeKB = new BigDecimal(fileSizeBytes)
                .divide(ONE_KILOBYTE, 2, RoundingMode.UP);
    }
}
// {/fact}
