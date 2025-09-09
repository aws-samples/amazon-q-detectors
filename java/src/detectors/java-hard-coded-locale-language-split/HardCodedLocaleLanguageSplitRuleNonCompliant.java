// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-split@v1.0 defects=1}
public class HardCodedLocaleLanguageSplitRuleNonCompliant {

    // Noncompliant: Given locale `myLocale` is being manually split.
    public void nonCompliant(){
        String myLocale = "en_US";
        String language = myLocale.split("-")[0];
        String country = myLocale.split("-")[1];

        String language1 = myLocale.split("n")[0];
    }
}
// {/fact}
