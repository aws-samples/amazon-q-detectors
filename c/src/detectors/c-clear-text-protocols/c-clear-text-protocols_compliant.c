// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-clear-text-protocols@v1.0 defects=0}
#include <stdlib.h>

typedef void CURL;
typedef int CURLcode;
typedef int CURLoption;

CURL* curl_easy_init()
{
    CURL *curl = malloc(sizeof(CURL));
    return curl;
}

CURLoption CURLOPT_URL, CURLOPT_USE_SSL;
const int CURLUSESSL_ALL = 0;

CURLcode my_curl_easy_setopt(CURL *handle, CURLoption option, const void *parameter)
{
    CURLcode cur = 0;
    return cur;
}

int compliant()
{
    // Compliant: Using encrypted protocols like SFTP.
    char* sftp_url = "sftp://anonymous@example.com";

    return 0;
}
// {/fact}