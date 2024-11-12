// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-trust-manager@v1.0 defects=1}

import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public abstract class TrustAllManagerNonCompliant implements X509TrustManager {

    // Noncompliant: X509TrustManager implementation with empty checkServerTrusted method, bypassing certificate validation and trusting any server.
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }
    private KeyStore loadKeyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (InputStream is = new FileInputStream("path/to/your/keystore.jks")) {
            keyStore.load(is, "keystorePassword".toCharArray());
        }
        return keyStore;
    }
}
// {/fact}