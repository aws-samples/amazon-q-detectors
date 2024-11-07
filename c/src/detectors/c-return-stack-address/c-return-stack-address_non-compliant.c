// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-return-stack-address@v1.0 defects=1}
int* noncompliant() {
    //NonCompliant : Insecure because it returns the address of a local variable, which becomes invalid after the function returns.
    int localVar = 42;
    return &localVar;
}
int main() {
   noncompliant();
   return 0;
}
// {/fact}