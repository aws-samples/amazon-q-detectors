// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deprecated-class@v1.0 defects=1}
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.IOException;

class DeprecatedClassJavaRuleNoncompliant {
    // Noncompliant: Uses deprecated `DefaultHttpClient` class, which has been replaced by newer, more secure alternatives.
    public void nonCompliant() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://google.com");
        HttpResponse response = client.execute(request);
    }
}
// {/fact}
