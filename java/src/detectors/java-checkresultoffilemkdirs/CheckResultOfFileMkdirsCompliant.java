// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultoffilemkdirs@v1.0 defects=0}
package rules.missing_check_on_method_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CheckResultOfFileMkdirsCompliant {

    private static final Logger log = LoggerFactory.getLogger(CheckResultOfFileMkdirsCompliant.class);

    private void compliant(String dirName, String fileName, String message) {
        try {
            File dir = new File(dirName);
            if (!dir.exists()) {
                // Compliant: Using `java.io.File.mkdirs()` to create directories with verifying if the operation was successful.
                if (!dir.mkdirs()) {
                    log.warn("Error creating directories for " + dir.toString());
                }
            }
            try (FileOutputStream fos = new FileOutputStream(new File(dir, fileName))) {
                fos.write(message.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// {/fact}