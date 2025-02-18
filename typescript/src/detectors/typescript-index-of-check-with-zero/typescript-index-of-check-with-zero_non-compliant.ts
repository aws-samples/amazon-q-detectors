// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-index-of-check-with-zero@v1.0 defects=1}
const arrayLike = {
    length: 3,
    0: 2,
    1: 3,
    2: 4,
  };
  
  // Noncompliant: `indexOf` method is compared with values greater than zero.
  if ((Array.prototype.indexOf.call(arrayLike, 2)) > 0){
     //Do something
  }
// {/fact}
