// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-find-max-or-min-using-stream-sort@v1.0 defects=0}
import java.util.Collection;
import java.util.Optional;

public class StreamMinMaxVsSortCompliant {

    Optional<String> MinCompliant(final Collection<String> col) {
        // Compliant: Uses min, max methods over sorted and findFirst stream methods.
        return col.stream().min(String::compareTo);
    }
}
// {/fact}
