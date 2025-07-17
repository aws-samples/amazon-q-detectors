// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-random-fd-exhaustion@v1.0 defects=0}
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

int compliant() {

    int random_file_descriptor;
    int num_bytes_read;
    char random_buffer[16];
    
    random_file_descriptor = open("/dev/urandom", 0);
    memset(random_buffer, 0, sizeof(random_buffer));
    
    // Compliant: Manage and limit the resource allocations properly and implement appropriate error handling.
    num_bytes_read = read(random_file_descriptor, random_buffer, sizeof(random_buffer));
    if (num_bytes_read != sizeof(random_buffer)) {
        return -1;
    }

    return 0;
}
// {/fact}
