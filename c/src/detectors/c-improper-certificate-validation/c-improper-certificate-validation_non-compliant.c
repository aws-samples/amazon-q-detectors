// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-improper-certificate-validation@v1.0 defects=1}

#include <stdio.h>

#define X509_V_OK 1
#define X509_V_ERR_CERT_HAS_EXPIRED 1

char* SSL_get_peer_certificate(char *ssl) {
    return NULL;
}

int SSL_get_verify_result(char* ssl) {
    return 0;
}

int non_compliant() {
    char* ssl = NULL;
    char* cert;

    // Noncompliant: Certificate is retrieved but not verified.
    cert = SSL_get_peer_certificate(ssl);
    if (cert) {
        printf("Certificate retrieved\n");
    } else {
        printf("No certificate available\n");
    }

    return 0;
}

int main() {
    return non_compliant();
}

// {/fact}
