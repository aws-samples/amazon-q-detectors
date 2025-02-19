// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ognl-injection@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;

public class OgnlInjectionNonCompliant {
    public void nonCompliant(HttpServletRequest request, OgnlReflectionProvider reflectionProvider, Class type) throws IntrospectionException, ReflectionException {
        String input = request.getParameter("input");
        // Noncompliant: Running scripts from unsanitized inputs allows remote code execution.
        reflectionProvider.getGetMethod(type, input);
    }
}
// {/fact}
