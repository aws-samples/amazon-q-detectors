// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ldap-injection@v1.0 defects=1}
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.servlet.http.HttpServletRequest;

public class LdapInjectionNoncompliant {

    // Noncompliant: unsanitized user-supplied filter is used.
    public void ldapSearchNoncompliant(HttpServletRequest request) {
        try {
            DirContext ctx = new InitialDirContext();
            String filter = request.getParameter("filter");
            ctx.search("Some name", filter, new SearchControls());
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
}
// {/fact}
