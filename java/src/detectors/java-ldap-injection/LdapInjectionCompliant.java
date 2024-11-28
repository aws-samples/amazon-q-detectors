// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ldap-injection@v1.0 defects=0}
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.naming.NamingEnumeration;

public class LdapInjectionCompliant {

    // Compliant: User-supplied filter is checked for allowed characters to prevent ldap injection.
    public void ldapSearchCompliant(HttpServletRequest request) {
        try {
            DirContext directoryContext = new InitialDirContext();
            SearchControls controls = new SearchControls();
            final String filter = request.getParameter("filter");
            if (!filter.matches("[a-z]+")) {
                throw new IllegalArgumentException();
            }
            Object[] args = new Object[]{"Some object"};
            String base = "some base";
            NamingEnumeration<SearchResult> results =
                    directoryContext.search(base, filter, args, controls);
            System.out.println(results);
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
}
// {/fact}
