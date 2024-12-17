// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-country-as-string@v1.0 defects=0}

public class HardcodedCountryAsStringRuleCompliant {

    // Compliant: Country name is passed from method argument.
    public void compliant(String country){
        String countryName = country;
        String random = country;
    }
}
// {/fact}
