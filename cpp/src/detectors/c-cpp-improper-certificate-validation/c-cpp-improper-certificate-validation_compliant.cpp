// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-improper-certificate-validation@v1.0 defects=0}
#include <stdio.h>
#include <openssl/ssl.h>
#include <openssl/err.h>
#include <openssl/x509.h>

int compliant() {
    SSL_CTX *ctx;
    SSL *ssl;
    X509 *cert;
    const char *hostname = "www.example.com";

    OpenSSL_add_all_algorithms();

    // Compliant: SSL_get_verify_result() has been called after the following SSL_get_peer_certificate() call.
    cert = SSL_get_peer_certificate(ssl);
    if (cert == NULL) {
        printf("No certificate was presented by the peer.\n");
    } else {
        X509_NAME *subj = X509_get_subject_name(cert);
        char *subject_name = X509_NAME_oneline(subj, 0, 0);
        printf("Subject: %s\n", subject_name);

        X509_NAME *issuer = X509_get_issuer_name(cert);
        char *issuer_name = X509_NAME_oneline(issuer, 0, 0);
        printf("Issuer: %s\n", issuer_name);

        OPENSSL_free(subject_name);
        OPENSSL_free(issuer_name);

        X509_free(cert);
    }

    long verify_result = SSL_get_verify_result(ssl);
    if (verify_result != X509_V_OK) {
        printf("Certificate verification failed: %ld\n", verify_result);
    } else {
        printf("Certificate verification succeeded.\n");
    }

    SSL_free(ssl);
    SSL_CTX_free(ctx);

    return 0;
}
// {/fact}
