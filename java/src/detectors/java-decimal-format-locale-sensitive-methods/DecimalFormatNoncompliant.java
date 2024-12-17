// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-decimal-format-locale-sensitive-methods@v1.0 defects=1}
import java.text.DecimalFormat;

public class DecimalFormatNoncompliant {
    // Noncompliant: DecimalFormat created without explicit Locale, risking inconsistent formatting across systems.
    public void DecimalFormat_PatternOnlyConstructor() {
        DecimalFormat df = new DecimalFormat("0.00");
    }
}
// {/fact}
