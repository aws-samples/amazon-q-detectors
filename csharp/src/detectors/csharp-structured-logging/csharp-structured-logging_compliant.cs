// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-structured-logging@v1.0 defects=0}
using Serilog;
using Serilog.Events;

namespace CSharpInjection.Compliant
{
    using Serilog;
    using Serilog.Events;

    class LogInjection
    {
        public void LogInjectionCompliant()
        {
            using var log = new LoggerConfiguration()
                .MinimumLevel.Debug()
                .WriteTo.Console(outputTemplate: "[{Timestamp:HH:mm:ss} {Level}] {Message:lj}{NewLine}{Exception}")
                .CreateLogger();

            var pos = new { Latitude = 25, Longitude = 134 };
            var elMs = 34;

            // Compliant: Use structured logging.
            log.Information("Processed {@Position} in {Elapsed:000} ms.", pos, elMs);
        }
        public static void Main()
        {
            LogInjection logInjection = new LogInjection();
            logInjection.LogInjectionCompliant();
        }
       
    }

}
 // {/fact}