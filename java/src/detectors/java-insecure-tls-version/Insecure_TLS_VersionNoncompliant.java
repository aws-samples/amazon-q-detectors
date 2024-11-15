// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-tls-version@v1.0 defects=1}
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

class Insecure_TLS_VersionNoncompliant  {

    // Noncompliant: Uses the deprecated and insecure SSL protocol instead of a more secure TLS version.
    public void noncompliant() throws NoSuchAlgorithmException {
        SSLContext sslcontext = SSLContext.getInstance("SSL");

    }

 }
// {/fact}