<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

//{fact rule=php-laravel-dangerous-model-construction@v1.0 defects=1}
namespace App\Models;
use Illuminate\Database\Eloquent\Model;
class FlightRecord extends Model
{
    protected $key = 'flight_id';
    // Noncompliant: Uses an empty `$guarded` array, allowing mass assignment for all attributes and potentially exposing the model to security vulnerabilities.
    protected $guarded = []; 

}
//{/fact}
?>
