// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-thread-safety-violation@v1.0 defects=1}
namespace ThreadSafe.NonCompliant
{
    class ThreadSafetyViolation
    {
        private int result = 0;
        private readonly object mainLock = new object();
        public void ThreadSafetyViolationNoncompliant()
        {
            for (int i = 0; i < 100000; i++)
            {
                // Noncompliant: This global variable is accessed without a lock.
                result = result + 1;
            }
        }
    }
}
// {/fact}