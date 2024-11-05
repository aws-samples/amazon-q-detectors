// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-bean-validation@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintValidatorContext

// Noncompliant: Unsafe Bean properties are passed directly to `buildConstraintViolationWithTemplate`
fun inseure_bean_noncompliant(request: HttpServletRequest, response: HttpServletResponse, constraintContext: ConstraintValidatorContext) {
    val constraintViolation: String = request.getAttribute("constraintViolation").toString()
    constraintContext.buildConstraintViolationWithTemplate(constraintViolation)
    .addConstraintViolation()
    .disableDefaultConstraintViolation()
}
// {/fact}