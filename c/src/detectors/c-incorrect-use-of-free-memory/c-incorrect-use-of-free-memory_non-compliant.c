// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-of-free-memory@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct NAME {
  char first_name[32];
  int auth;
} s_auth;

int noncompliant(){
    struct NAME *var;
    var = malloc(sizeof(s_auth));
    free(var);
    // Noncompliant: Using freed memory causes undefined behavior.
    if(var->auth){
        printf("you have logged in already");
    }
    else{
        printf("you do not have the permision to log in.");
    }
    return 0;

}
// {/fact}
