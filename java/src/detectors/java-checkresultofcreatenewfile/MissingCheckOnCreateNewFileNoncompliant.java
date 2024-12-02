// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultofcreatenewfile@v1.0 defects=1}
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

@Log4j
class MissingCheckOnCreateNewFileNoncompliant {

    // Noncompliant: Does not check if createNewFile succeeded or failed.
    public File createFileNonCompliant(File outputFolder, final String fileName) throws IOException {
        File file = new File(outputFolder, fileName);
        file.createNewFile();
        return file;
    }

}
// {/fact}
