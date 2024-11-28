// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultofcreatenewfile@v1.0 defects=0}

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.log4j.Log4j;

@Log4j
class MissingCheckOnCreateNewFileCompliant {

    // Compliant: handles the case when createNewFile fails.
    public Optional<File> createFileCompliant(File outputFolder, final String fileName) throws IOException {
        File file = new File(outputFolder, fileName);
        if (!file.createNewFile()) {
            log.debug("File already exists, using existing file " + file.getAbsolutePath() + ".");
            return Optional.empty();
        }
        return Optional.of(file);
    }
}
// {/fact}
