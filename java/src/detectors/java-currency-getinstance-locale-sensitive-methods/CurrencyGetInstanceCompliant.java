// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-currency-getinstance-locale-sensitive-methods@v1.0 defects=0}
import java.util.Currency;

public class CurrencyGetInstanceCompliant  {

    // Compliant: Uses Currency.getInstance with specific currency code, avoiding locale sensitivity.
    public void compliant() {
        Currency cur = Currency.getInstance("USD");
    }
}
// {/fact}
