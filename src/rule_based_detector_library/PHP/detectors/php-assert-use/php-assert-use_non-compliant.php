<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-assert-use@v1.0 defects=1}
// Noncompliant: The `userInput` is not sanitized.
    $unsanitizedInput = $_GET['userInput'];
    assert($unsanitizedInput);
// {/fact}
?>
