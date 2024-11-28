// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-untrusted-load@v1.0 defect=1}
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import org.springframework.web.bind.annotation.RequestParam;
public class UntrustedLoadJavaRuleNonCompliant {
    // NonCompliant: ObjectInputStream not validated
    public void nonCompliant(@RequestParam String param) throws Exception {
        try (FileInputStream fis = new FileInputStream(param);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object o = ois.readObject(); // non-conformant, ObjectInputStream not validated
            o.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// {/fact}