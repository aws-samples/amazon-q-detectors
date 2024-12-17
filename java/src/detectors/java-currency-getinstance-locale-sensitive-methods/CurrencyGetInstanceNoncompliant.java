// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-currency-getinstance-locale-sensitive-methods@v1.0 defects=1}
import java.util.Currency;
import java.util.Locale;

public class CurrencyGetInstanceNoncompliant  {

    // Noncompliant: Uses invalid currency code "foo" with Currency.getInstance, risking runtime exceptions.
    public void nonCompliant() {
        Currency cur = Currency.getInstance(Locale.US);
    }
}
// {/fact}
