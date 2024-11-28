// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ldap-injection@v1.0 defect=0}
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.RequestParam;

public class LDAPInjectionJavaRuleCompliant {
    // Compliant: Sanitized input is being used in LDAP statement
    public void compliant(@RequestParam String input) throws NamingException {
        String sanitizedInput = StringEscapeUtils.escapeHtml4(input);
        DirContext context = new InitialDirContext(new Hashtable<>());
        BasicAttributes matchingAttributes = new BasicAttributes();
        matchingAttributes.put("attr", sanitizedInput);
        context.search("Search", matchingAttributes);
    }
}
// {/fact}