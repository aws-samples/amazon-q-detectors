// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-clear-text-protocols@v1.0 defects=1}
typedef void CURL;
typedef int CURLcode;

typedef int CURLoption;

CURL* curl_easy_init()
{
    CURL *curl;
    return curl;
}

CURL* curl_easy_init1()
{
    CURL *curl;
    return curl;
}

CURLoption CURLOPT_URL,CURLOPT_USE_SSL;
const char CURLUSESSL_ALL;

CURLcode my_curl_easy_setopt1(CURL *handle, CURLoption option, const char *url)
{
    CURLcode *curl;
    return *curl;
}

int noncompliant()
{
    // Noncompliant: Using unencrypted protocols such as HTTP.
    char* http_url = "http://example.com";
    return 0;
}
// {/fact}
