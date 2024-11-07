<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-ftp-use@v1.0 defects=0}
// Compliant: Secure file transfer using functions like `ssh2_auth_password`.
ssh2_auth_password($sshConnection, $username, $password);
// {/fact}
?>
