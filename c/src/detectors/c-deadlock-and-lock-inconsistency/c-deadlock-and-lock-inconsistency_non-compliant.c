// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-deadlock-and-lock-inconsistency@v1.0 defects=1}
#include <pthread.h>
#include <stdio.h>

void noncompliant()
{
    pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

    pthread_mutex_lock(&mutex);

    // Noncompliant: Double `pthread_mutex_lock()` without unlock causes deadlock.
    pthread_mutex_lock(&mutex);

    pthread_mutex_unlock(&mutex);
}
// {/fact}
