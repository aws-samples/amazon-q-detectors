// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultoffilemkdirs@v1.0 defects=1}
package rules.missing_check_on_method_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

@Log4j
class CheckResultOfFileMkdirsNonCompliant {

    private void non_compliant(String dirName, String fileName, String message) {
        try {
            File dir = new File(dirName);
            if (!dir.exists()) {
                // Noncompliant: Using `java.io.File.mkdirs()` to create directories without verifying if the operation was successful.
                dir.mkdirs();
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