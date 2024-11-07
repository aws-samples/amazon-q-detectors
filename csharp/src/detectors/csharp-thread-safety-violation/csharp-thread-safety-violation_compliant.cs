// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-thread-safety-violation@v1.0 defects=0}
namespace ThreadSafe.Compliant
{
    class ThreadSafetyViolation
    {
        private int result = 0;
        private readonly object mainLock = new object();
        public void ThreadSafetyViolationCompliant()
        {
            for (int i = 0; i < 100000; i++)
            {
                // Compliant: Provide lock to protect the integrity of the global variable.
                lock (mainLock)
                {
                    result = result + 1;
                }
            }
        }
        public static void Main()
        {
            var instance = new ThreadSafetyViolation();
            instance.ThreadSafetyViolationCompliant();
        }
    }
}
// {/fact}