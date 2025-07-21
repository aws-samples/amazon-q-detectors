// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-improper-certificate-validation@v1.0 defects=0}

#include <stdio.h>

#define X509_V_OK 1
#define X509_V_ERR_CERT_HAS_EXPIRED 1

char* SSL_get_peer_certificate(char *ssl) {
    return NULL;
}

int SSL_get_verify_result(char* ssl) {
    return 0;
}

int compliant() {
    char* ssl = NULL;
    char* cert;

    // Compliant: Certificate is retrieved and properly verified.
    cert = SSL_get_peer_certificate(ssl);

    if (cert == NULL) {
        printf("No certificate available\n");
        return 1;
    }

    int result = SSL_get_verify_result(ssl);

    if (result != X509_V_OK) {
        printf("Failed to verify server certificate\n");
        return 1;
    }

    printf("Certificate verified successfully\n");
    return 0;
}

int main() {
    return compliant();
}

// {/fact}
