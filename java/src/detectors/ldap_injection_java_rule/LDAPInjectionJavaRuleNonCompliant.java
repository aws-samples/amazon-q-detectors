// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ldap-injection@v1.0 defect=1}
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;
import org.springframework.web.bind.annotation.RequestParam;
public class LDAPInjectionJavaRuleNonCompliant {
    // NonCompliant: Unsanitized input passed to LDAP statement
    public void nonCompliant(@RequestParam String input) throws NamingException {
        DirContext context = new InitialDirContext(new Hashtable<>());
        BasicAttributes matchingAttributes = new BasicAttributes();
        matchingAttributes.put("attr", input);
        context.search("Search", matchingAttributes);
    }
}
// {/fact}