<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: MIT-0
*/

//{fact rule=php-symfony-non-literal-redirect@v1.0 defects=0}
// Compliant: Uses `redirectToRoute()` method, which internally validates and constructs the URL, mitigating risks associated with open redirects.
use Symfony\Component\HttpFoundation\RedirectResponse;
class WebAppController
{
    public function compliantRedirect(): RedirectResponse
    {
        $foo = $session->get('foo');
        return $this->redirectToRoute($foo);
    }
}
//{/fact}
?>
