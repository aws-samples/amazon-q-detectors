// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-ldap-injection@v1.0 defects=1}
import javax.naming.directory.InitialDirContext
import javax.naming.directory.SearchControls
import javax.servlet.http.HttpServletRequest

fun ldap_injection_noncompliant(request: HttpServletRequest) {
    val context = InitialDirContext()
    // Noncompliant: Using unsanitized user input directly in LDAP search filter enables LDAP injection.
    val filter = "(&(uid=${request.getParameter("username")}))"
    context.search("ou=users", filter, SearchControls())
}
// {/fact}
