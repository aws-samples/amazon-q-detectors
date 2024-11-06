<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-tainted-object-instantiation@v1.0 defects=0}
// Compliant: Uses a hardcoded class name for instantiation, preventing potential object injection vulnerabilities.
$controllerClassName = "MyController";
$controllerInstance = new $controllerClassName();
// {/fact}

?>
