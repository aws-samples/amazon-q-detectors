// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-tls-version@v1.0 defects=1}
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

class InsecureTLSVersionNoncompliant  {

    // Noncompliant: Uses the deprecated and insecure SSL protocol instead of a more secure TLS version.
    public void nonCompliant() throws NoSuchAlgorithmException {
        SSLContext sslcontext = SSLContext.getInstance("SSL");
    }
 }
// {/fact}
