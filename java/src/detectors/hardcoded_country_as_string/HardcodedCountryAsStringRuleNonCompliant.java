// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-country-as-string@v1.0 defects=1}

public class HardcodedCountryAsStringRuleNonCompliant {

    // Noncompliant: Hardcoded country name is used.
    public void nonCompliant() {
        String countryMusic = "Senorita";
        String countryName = "INDIA";
    }
}
// {/fact}
