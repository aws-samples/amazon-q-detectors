// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

import javax.naming.directory.SearchControls

class InsecureLdapConfigurationNoncompliant {
  private val scope = 0
  private val countLimit = 0
  private val timeLimit = 0
  private val attributes = null
  private val deref = false

  // {fact rule=scala-insecure-ldap-configuration@v1.0 defects=1}
  def insecureLdapConfigurationNoncompliant(): Unit = {
    // Noncompliant: `returnObjFlag` is set to `true`.
    new SearchControls(scope, countLimit, timeLimit, attributes, true,
      deref)
  }

}
// {/fact}
