// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-return-stack-address@v1.0 defects=0}
#define STR_MAX 256
int global_var = 42;

int* compliant() {
    //Compliant : Use heap-allocated memory, use static local variables when appropriate, or redesign the function to avoid returning local addresses.
    return &global_var;
}

int main() {
   compliant();
   return 0;
}
// {/fact}