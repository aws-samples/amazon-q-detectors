// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-structured-logging@v1.0 defects=1}
using Serilog;
using Serilog.Events;

namespace CSharpInjection.NonCompliant
{
    class LogInjection
    {
        public void LogInjectionNoncompliant()
        {
            using var log = new LoggerConfiguration()
                .MinimumLevel.Debug()
                .WriteTo.Console(outputTemplate: "[{Timestamp:HH:mm:ss} {Level}] {Message:lj}{NewLine}{Exception}")
                .CreateLogger();

            var pos = new { Latitude = 25, Longitude = 134 };
            var elMs = 34;

           // Noncompliant: String interpolation in log message can lead to log injection vulnerabilities.
            log.Information($"Processed {pos} in {elMs:000} ms.");
        }
    }
}
 // {/fact}
