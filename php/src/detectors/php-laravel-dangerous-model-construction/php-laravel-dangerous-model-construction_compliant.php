<?php
//  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
//  SPDX-License-Identifier: MIT-0

// {fact rule=php-laravel-dangerous-model-construction@v1.0 defects=0}
namespace App\Models;
use Illuminate\Database\Eloquent\Model;
class FlightDetails extends Model
{
    protected $key = 'flight_id';
    // Compliant: Uses `$guarded` to explicitly specify attributes that should not be mass-assignable, enhancing security against mass assignment vulnerabilities.
    protected $guarded = ['name', 'email'];

}
// {/fact}
?>
