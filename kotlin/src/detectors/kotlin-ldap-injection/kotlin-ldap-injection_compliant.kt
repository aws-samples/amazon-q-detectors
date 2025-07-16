// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-ldap-injection@v1.0 defects=0}
import javax.naming.directory.InitialDirContext
import javax.naming.directory.SearchControls
import javax.servlet.http.HttpServletRequest

// Compliant: Using parameterized search with placeholders prevents LDAP injection.
fun ldap_injection_compliant(request: HttpServletRequest) {
    val context = InitialDirContext()
    val username = request.getParameter("username")
    val filter = "(&(uid={0}))"
    context.search("ou=users", filter, arrayOf(username), SearchControls())
}
// {/fact}
