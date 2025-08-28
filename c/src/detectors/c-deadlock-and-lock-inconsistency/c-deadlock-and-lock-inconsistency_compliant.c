// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-deadlock-and-lock-inconsistency@v1.0 defects=0}
#include <pthread.h>
#include <stdio.h>

void compliant()
{
    pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

    pthread_mutex_lock(&mutex);

    // Compliant: Proper `pthread_mutex_lock()` and `pthread_mutex_unlock()` pairing prevents deadlock.
    printf("Critical section\n");

    pthread_mutex_unlock(&mutex);

    pthread_mutex_lock(&mutex);
    printf("Another critical section\n");
    pthread_mutex_unlock(&mutex);
}
// {/fact}
