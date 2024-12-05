// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handleexceptiononmethodinvoke@v1.0 defects=1}
import java.lang.reflect.Method;

class MissingGetCauseOnInvocationTargetExceptionNoncompliant {

    // Noncompliant: Exception `InvocationTargetException` is not caught.
    public Object nonCompliant(Method method, Object[] args) throws Throwable {
        return method.invoke(args);
    }
}
// {/fact}
