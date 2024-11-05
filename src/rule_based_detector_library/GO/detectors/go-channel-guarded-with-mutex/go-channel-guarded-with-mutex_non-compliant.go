// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package channel

// {fact rule=go-channel-guarded-with-mutex@v1.0 defects=1}
import (
	"fmt"
	"sync"
)

func channelGuardedWithMutexNoncompliant() {
	var mutex = &sync.Mutex{}
	msg := make(chan string)

	go func() {
		msg <- "ping"
	}()

	// Noncompliant: Channel guarded with mutex.
	mutex.Lock()
	message := <-msg
	mutex.Unlock()
	fmt.Println(message)
}
// {/fact}
