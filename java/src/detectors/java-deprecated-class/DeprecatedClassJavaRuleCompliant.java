// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deprecated-class@v1.0 defects=0}
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

class DeprecatedClassJavaRuleCompliant {
    // Compliant: Uses `HttpClientBuilder` to create a non-deprecated `HttpClient` instance for making HTTP requests.
    public void compliant() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://google.com");
        HttpResponse response = client.execute(request);
    }
}
// {/fact}
