<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-ldap-bind-without-password@v1.0 defects=1}
// Noncompliant: Username and password is missing.
$ldapConnection = ldap_connect("foo.com");
ldap_bind($ldapConnection, NULL, NULL);
// {fact}
?>
