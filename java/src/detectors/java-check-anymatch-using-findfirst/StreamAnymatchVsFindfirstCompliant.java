// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-check-anymatch-using-findfirst@v1.0 defects=0}

import java.util.Collection;
import java.util.Objects;

public class StreamAnymatchVsFindfirstCompliant {
    Collection<String> col;

    boolean streamCollectionCompliant(final Collection<String> col) {
        // Compliant: Uses anyMatch stream method over the others which is more readable and convenient.
        return col.stream().anyMatch(Objects::isNull);
    }
}
// {/fact}
