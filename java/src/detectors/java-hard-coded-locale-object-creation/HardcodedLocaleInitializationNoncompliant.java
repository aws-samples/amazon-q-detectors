// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-object-creation@v1.0 defects=1}
import java.util.Locale;

public class HardcodedLocaleInitializationNoncompliant {

    // Noncompliant: Hardcoded a specific locale.
    Locale DEFAULT_LOCALE = new Locale("en", "US");
}
// {/fact}
