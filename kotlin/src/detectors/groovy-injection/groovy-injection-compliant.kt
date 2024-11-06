// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-groovy-injection@v1.0 defects=0}
import groovy.lang.GroovyShell
import javax.servlet.http.HttpServletRequest

// Compliant: Pre-defined string gets executed as a code.
fun groovy_injectionn_compliant(request: HttpServletRequest) {
    val shell = GroovyShell()
    val script: String = request.getParameter("script")
    shell.evaluate("script")
}
// {/fact}
