<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

// {fact rule=php-tainted-object-instantiation@v1.0 defects=1}
// Noncompliant: Uses unvalidated user input to dynamically instantiate objects, potentially allowing object injection attacks.
$pathParts = explode("/", $_REQUEST['PATH_INFO']);
$controllerClassName = $pathParts[0];
$controllerInstance = new $controllerClassName($pathParts[1]);
// {/fact}

?>
