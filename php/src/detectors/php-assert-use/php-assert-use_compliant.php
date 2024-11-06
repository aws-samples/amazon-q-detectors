<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-assert-use@v1.0 defects=0}
// Compliant: `assert` input is not tainted.
   assert('3 > 2');
// {/fact}

?>
