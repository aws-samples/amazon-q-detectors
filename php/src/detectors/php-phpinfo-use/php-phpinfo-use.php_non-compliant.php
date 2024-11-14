<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-phpinfo-use@v1.0 defects=1}
// Noncompliant: Calls and outputs `phpinfo()`, potentially exposing sensitive system and configuration information to unauthorized users.
echo phpinfo();
// {/fact}
?>