// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-bean-validation@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintValidatorContext
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext
import org.apache.commons.lang3.StringEscapeUtils

// Compliant: Safe Bean properties are passed to `buildConstraintViolationWithTemplate`
fun inseure_bean_compliant(request: HttpServletRequest, response: HttpServletResponse, constraintContext: ConstraintValidatorContext) {
    constraintContext.buildConstraintViolationWithTemplate(StringEscapeUtils.escapeHtml4(request.getParameter("unsafeTemplate")))
            .addConstraintViolation()
            .disableDefaultConstraintViolation()
}
// {/fact}