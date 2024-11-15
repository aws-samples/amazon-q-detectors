// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-url-instantiated@v1.0 defects=0}
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;


public class UrlInstantiatedRuleTestCasesCompliant {
    // Compliant: Uses HTTPS for URL instantiation, ensuring secure communication and data protection.
    public void compliant() {
        try {
            URL url = new URL("https://www.example.com/");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.connect();
        } catch (IOException e) {
        }
    }
}
// {/fact}