// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-notthreadsafeclass@v1.0 defects=1}
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class NotThreadSafeClassNonCompliant {

    private Map<String, String> fileInfoMap = new HashMap<>();

    // Noncompliant: The method doesn't protect against the parallel use of map.
    public String getFileInfo(String fileName) {
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
