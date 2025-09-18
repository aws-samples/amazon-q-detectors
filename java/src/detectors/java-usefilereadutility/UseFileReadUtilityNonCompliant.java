// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-usefilereadutility@v1.0 defects=1}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UseFileReadUtilityNonCompliant {
    // Noncompliant: Custom reading operation used to read from input stream .
    static public String nonCompliant() {
        try {
            URL url = new URL("http://docs.amazon.com/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println("status " + status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return inputLine;
        } catch (Exception e) {
            System.out.println("internet not available");
        }
        return null;
    }
}
// {/fact}
