<?php
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=php-symfony-csrf-protection-disabled@v1.0 defects=0}
use Symfony\Component\Form\AbstractType;
// Compliant: `CSRF` protection enabled.
class Type extends AbstractType
{
  public function compliant(OptionsResolver $resolver)
  {
    $csrfResolver = $resolver;
    $csrfResolver->setDefaults([
        'csrf_protection' => true
    ]);
  }
}
// {/fact}
?>
