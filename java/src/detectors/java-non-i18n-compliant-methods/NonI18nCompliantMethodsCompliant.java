// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-charset-default-charset-non-i18n-compliant-methods@v1.0 defects=0}
import java.util.Locale;

public class NonI18nCompliantMethodsCompliant {

    // Compliant: Uses a specific Locale like `Locale.CANADA` instead of relying on the default charset or locale.
    public void compliant() {
        final String country = Locale.CANADA.getCountry();
    }
}
// {/fact}
