// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-url-instantiated@v1.0 defects=1}
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;


public class UrlInstantiatedRuleTestCasesNoncompliant {
    // Noncompliant: Uses HTTP instead of HTTPS for URL instantiation, potentially exposing data to interception.
    public void compliant() {
        try {
            URL url = new URL("http://www.example.com/");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.connect();
        } catch (IOException e) {
        }
    }
}
// {/fact}