// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-usefilereadutility@v1.0 defects=0}
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class UseFileReadUtilityCompliant {

    // Compliant: Instead of using custom set of operation, using standard `FileIO` to read from inputStream.
    static public String compliant() {
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println("status " + status);
            String gateway = IOUtils.toString(con.getInputStream());
            return gateway;

        } catch (Exception e) {
            System.out.println("internet not available");
        }
        return null;
    }
}
// {/fact}
