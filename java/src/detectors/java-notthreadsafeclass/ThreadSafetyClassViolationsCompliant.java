// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-notthreadsafeclass@v1.0 defects=0}
import com.amazonaws.annotation.ThreadSafe;
import java.util.HashMap;
import stubs.FileInfo;

@ThreadSafe
public class ThreadSafetyClassViolationsCompliant {

    private HashMap<String, FileInfo> fileInfoMap = new HashMap<String, FileInfo>();

    // Compliant: All methods are thread-safe.
    public synchronized void reset() {
        fileInfoMap.clear();
    }

    public synchronized void addFileInfo(String fileName, long fileSize) {
        FileInfo fileInfo = new FileInfo(fileName, fileSize);
        fileInfoMap.put(fileName, fileInfo);
    }

    public synchronized FileInfo getFileInfoSync(String fileName) {
        return fileInfoMap.get(fileName);
    }
}
// {/fact}
