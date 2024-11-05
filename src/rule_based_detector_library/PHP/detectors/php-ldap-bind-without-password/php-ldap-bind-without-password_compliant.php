<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-ldap-bind-without-password@v1.0 defects=0}
// Compliant: Username and password provided.
$ldapConnection = ldap_connect("foo.com");
ldap_bind($ldapConnection, "user@example.com", "securePassword123");
//{fact}
?>
