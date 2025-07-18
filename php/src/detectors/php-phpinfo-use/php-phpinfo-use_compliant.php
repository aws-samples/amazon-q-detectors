<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-phpinfo-use@v1.0 defects=0}
function compliant() {
    // Compliant: Providing limited, safe system information.
    echo "PHP Version: " . PHP_VERSION . "<br>";
    echo "Server Software: " . $_SERVER['SERVER_SOFTWARE'] . "<br>";
}
// {/fact}
?>
