// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-find-max-or-min-using-stream-sort@v1.0 defects=1}
import java.util.Collection;
import java.util.Optional;

public class StreamMinMaxVsSortNoncompliant {

    Optional<String> streamSortThenFindFirstNoncompliant(final Collection<String> col) {
        // Noncompliant: Uses sorted and findFirst over min, max stream methods.
        return col.stream()
                .sorted()
                .findFirst();
    }
}
// {/fact}
