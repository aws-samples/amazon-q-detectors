// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-ldap-configuration@v1.0 defects=0}
import javax.naming.directory.SearchControls

class InsecureLdapConfigurationCompliant {

  private val scope = 0
  private val countLimit = 0
  private val timeLimit = 0
  private val attributes = null
  private val deref = false

  def insecureLdapConfigurationCompliant(): Unit = {
    // Compliant: `returnObjFlag` is set to `false`.
    new SearchControls(scope, countLimit, timeLimit, attributes, false,
      deref)
  }

}
// {/fact}
