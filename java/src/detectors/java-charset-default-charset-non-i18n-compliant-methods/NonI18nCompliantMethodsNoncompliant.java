// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-charset-default-charset-non-i18n-compliant-methods@v1.0 defects=1}
import java.nio.charset.Charset;

public class NonI18nCompliantMethodsNoncompliant {

    // Noncompliant: Uses `Charset.defaultCharset()`, which is platform-dependent and can lead to internationalization issues.
    public void nonCompliant() {
        Charset myCharset = Charset.defaultCharset();
    }
}
// {/fact}
