// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-decimal-format-locale-sensitive-methods@v1.0 defects=0}
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormatCompliant {

    // Compliant: DecimalFormat uses explicit Locale, avoiding locale-sensitive behavior issues.
    public void DecimalFormat_FullConstructor_WithHardCodedLocale() {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.getDefault()));
    }
}
// {/fact}
