// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package channel

// {fact rule=go-channel-guarded-with-mutex@v1.0 defects=0}
import (
	"fmt"
)

func channelGuardedWithMutexCompliant() {
	msg := make(chan string)

	go func() {
		msg <- "ping"
	}()

	// Compliant: Channel is not guarded with mutex.
	message := <-msg
	fmt.Println(message)
}
// {/fact}
