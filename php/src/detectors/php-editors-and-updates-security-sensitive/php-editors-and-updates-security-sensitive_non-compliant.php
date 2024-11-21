<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-editors-and-updates-security-sensitive@v1.0 defects=1}
// Noncompliant: Disables automatic core updates, potentially leaving WordPress vulnerable to security issues
define( 'WP_AUTO_UPDATE_CORE', false ); 
// {/fact}
?>