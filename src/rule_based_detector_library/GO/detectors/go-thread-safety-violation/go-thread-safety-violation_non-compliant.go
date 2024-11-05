// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package thread_safety

// {fact rule=go-thread-safety-violation@v1.0 defects=1}
import (
	"sync"
)

func threadSafetyViolationNoncompliant() {
	var counter int
	var wg sync.WaitGroup

	for i := 0; i < 1000; i++ {
		wg.Add(1)
		go func() {
			// Noncompliant: Incrementing without synchronization.
			// Multiple goroutines may access `counter` at the same time, leading to a race condition.
			counter++
			wg.Done()
		}()
	}
	wg.Wait()
}
// {/fact}
