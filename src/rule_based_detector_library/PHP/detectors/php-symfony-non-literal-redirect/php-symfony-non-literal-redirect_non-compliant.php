<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-symfony-non-literal-redirect@v1.0 defects=1}
// Noncompliant: Uses `redirect()` with unvalidated user input, potentially allowing open redirect vulnerabilities.
use Symfony\Component\HttpFoundation\RedirectResponse;
class WebAppController
{
    public function nonCompliantRedirect(): RedirectResponse
    {
        $foo = $session->get('foo');
        return $this->redirect($foo);
    }
}
//{/fact}
?>
