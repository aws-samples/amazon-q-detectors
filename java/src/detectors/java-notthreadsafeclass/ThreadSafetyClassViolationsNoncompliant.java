// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-notthreadsafeclass@v1.0 defects=1}
import com.amazonaws.annotation.ThreadSafe;
import stubs.FileInfo;
import java.util.HashMap;

@ThreadSafe
public class ThreadSafetyClassViolationsNoncompliant {

    private HashMap<String, FileInfo> fileInfoMap = new HashMap<String, FileInfo>();

    public synchronized void reset() {
        fileInfoMap.clear();
    }

    public synchronized void addFileInfo(String fileName, long fileSize) {
        FileInfo fileInfo = new FileInfo(fileName, fileSize);
        fileInfoMap.put(fileName, fileInfo);
    }

    // Noncompliant: The method doesn't protect the parallel use of map.
    public FileInfo getFileInfo(String fileName) {
        return fileInfoMap.get(fileName);
    }

    public synchronized FileInfo getFileInfoSync(String fileName) {
        return fileInfoMap.get(fileName);
    }
}
// {/fact}
