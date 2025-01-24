// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-ognl-injection@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class OgnlInjectionCompliant {
    public void compliant(HttpServletRequest request, OgnlReflectionProvider reflectionProvider, Class type) throws IntrospectionException, ReflectionException {
        String input = request.getParameter("input");
        // Compliant: Sanitize the input before using it helps prevent remote code execution.
        if (isValidMethodName(input)) {
            reflectionProvider.getGetMethod(type, input);
        }
    }

    private boolean isValidMethodName(String input) {
        return Pattern.matches("^[a-zA-Z_$][a-zA-Z\\d_$]*$", input);
    }
}
// {/fact}
