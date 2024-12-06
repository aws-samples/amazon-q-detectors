// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handleexceptiononmethodinvoke@v1.0 defects=0}
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MissingGetCauseOnInvocationTargetExceptionCompliant {

    // Compliant: Exception `InvocationTargetException` is caught and `e.getCause()` is propagated further.
    public Object compliant(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Object returnValue = method.invoke(args);
            return returnValue;
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
// {/fact}
