// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-check-anymatch-using-findfirst@v1.0 defects=1}

import java.util.Collection;
import java.util.Objects;

public class StreamAnymatchVsFindfirstNoncompliant {
    Collection<String> col;

    boolean streamCollectionNoncompliant(final Collection<String> col) {
        // Noncompliant: Uses a chain of "filter", "findFirst" and "isPresent" stream methods over anyMatch.
        return col.stream()
                .filter(Objects::isNull)
                .findFirst()
                .isPresent();
    }
}
// {/fact}
