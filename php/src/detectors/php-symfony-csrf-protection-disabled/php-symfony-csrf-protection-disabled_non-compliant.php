<?php

//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0
use Symfony\Component\Form\AbstractType;
// {fact rule=php-symfony-csrf-protection-disabled@v1.0 defects=1}
// Noncompliant: `CSRF` protection is disabled.
class Type extends AbstractType
{
  public function nonCompliant(OptionsResolver $resolver)
  {
    $csrfResolver = $resolver; 
    $csrfResolver->setDefaults(array(
        'csrf_protection' => false
    ));
  }
}
// {/fact}
?>
