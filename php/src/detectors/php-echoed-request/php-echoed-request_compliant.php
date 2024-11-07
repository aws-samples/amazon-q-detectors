<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-echoed-request@v1.0 defects=0}
function compliant() { 
    $userName = $_REQUEST['name'];
    // Compliant: `htmlentities` provides a compliant way to display user input safely.
    print("Hello: " . htmlentities($userName)); 
}
//{/fact}
?>
