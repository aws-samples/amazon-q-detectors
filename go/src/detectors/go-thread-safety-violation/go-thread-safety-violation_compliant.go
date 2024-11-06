// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package thread_safety

// {fact rule=go-thread-safety-violation@v1.0 defects=0}
import (
	"sync"
)

func threadSafetyViolationCompliant() {
	var counter int
	var wg sync.WaitGroup
	var mu sync.Mutex

	for i := 0; i < 1000; i++ {
		wg.Add(1)
		go func() {
			mu.Lock()
			// Compliant: `sync.Mutex` is used to ensure only one goroutine can modify shared data at a time.
			counter++
			mu.Unlock()
			wg.Done()
		}()
	}
	wg.Wait()
}
// {/fact}
