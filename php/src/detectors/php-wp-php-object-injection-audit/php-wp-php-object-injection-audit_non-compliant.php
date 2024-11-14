
<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-wp-php-object-injection-audit@v1.0 defects=1}
// Noncompliant: Tainted `inputData` is used, leading to potential insecure deserialization vulnerabilities.
$inputData = $_GET["inputData"];
$object = unserialize($inputData);
// {/fact}
?>
