// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-insecure-trust-manager@v1.0 defect=0}
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.TrustManagerFactory;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.security.KeyStoreException;


public abstract class GoodTrustManagerCompliant implements X509TrustManager {

    // Compliant: Proper implementation of `X509TrustManager` using `KeyStore` and `TrustManagerFactory`.
    @Override
    public void compliant(X509Certificate[] x509Certificates, String s) throws CertificateException  {
        try {
            KeyStore ks = loadKeyStore();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);
            tmf.getTrustManagers();
        }
        catch (Exception e){
        }
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