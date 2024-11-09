// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-insufficient-key-size@v1.0 defects=0}
#include <iostream>
#include <cstdint>

class EVP_PKEY_CTX
{
    // Placeholder for EVP_PKEY_CTX class, which would typically hold cryptographic context
};

void EVP_PKEY_CTX_set_rsa_keygen_bits(EVP_PKEY_CTX *ctx, int size)
{
}

void compliant(EVP_PKEY_CTX *ctx)
{
    // Compliant: Key sized of 2048 and above are secure. 
    EVP_PKEY_CTX_set_rsa_keygen_bits(ctx, 2048);  
}

int main()
{
    EVP_PKEY_CTX *ctx = new EVP_PKEY_CTX;
    compliant(ctx);
    delete ctx;
}
// {/fact}
