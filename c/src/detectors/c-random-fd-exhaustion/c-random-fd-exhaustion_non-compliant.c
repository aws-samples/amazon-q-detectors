// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-random-fd-exhaustion@v1.0 defects=1}
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

int noncompliant() {
    //NonCompliant : Failure to limit and close open file descriptors allows uncontrolled resource consumption, potentially impacting system stability and performance.
    int random_fd;
    char random_buffer[16];
    
    random_fd = open("/dev/urandom", 0);
    memset(random_buffer, 0, sizeof(random_buffer));
    read(random_fd, random_buffer, sizeof(random_buffer));
    
    return 0;
}
int main() {
   noncompliant();
   return 0;
}
// {/fact}