// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-notthreadsafeclass@v1.0 defects=0}
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class NotThreadSafeClassCompliant {

    private Map<String, String> fileInfoMap = new HashMap<>();

    // Compliant: `synchronized` keyword is used making the method thread safe.
    public synchronized String getFileInfo(String fileName) {
        return fileInfoMap.get(fileName);
    }

    public synchronized void reset() {
        fileInfoMap.clear();
    }

    public synchronized void addFileInfo(String fileName, long fileSize) {
        String fileInfo = "key";
        fileInfoMap.put(fileName, fileInfo);
    }

    public synchronized String getFileInfoSync(String fileName) {
        return fileInfoMap.get(fileName);
    }
}
// {/fact}
