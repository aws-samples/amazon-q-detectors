// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-tls-version@v1.0 defects=0}
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

class InsecureTLSVersionCompliant  {
    // Compliant: Uses the secure TLSv1.3 protocol, which is the latest and most secure version of TLS.
    public void compliant() throws NoSuchAlgorithmException {
        SSLContext sslcontext = SSLContext.getInstance("TLSv1.3");
    }
 }
// {/fact}
