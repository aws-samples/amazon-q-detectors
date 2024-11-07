// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-anonymous-ldap-bind@v1.0 defects=1}
import javax.naming.directory.InitialDirContext
import java.util.Hashtable
import javax.naming.Context
import javax.naming.directory.DirContext

// Noncompliant: Permiting anonymous users to execute LDAP statements
fun anonymous_ldap_bind_noncompliant(env: Hashtable<String, Any>) {
    env.put(Context.SECURITY_AUTHENTICATION, "none")
    val ctx: DirContext = InitialDirContext(env)
}
// {/fact}
