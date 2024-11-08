// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-catch-and-throw-exception@v1.0 defect=1}
import com.amazonaws.AmazonServiceException;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletException;

@Slf4j
public class DoNotCatchAndThrowExceptionNonCompliant {

    // Noncompliant: Exception caught and rethrown in catch block, potentially losing stack trace information.
    public void nonCompliant() {
        try {
            foo();
        } catch (AmazonServiceException t) {
            throw new RuntimeException(t.getMessage(), t);
        } catch (ServletException t) {
            throw new RuntimeException(t.getMessage(), t);
        } catch (Exception t) {
            throw t;
        }
    }
    void foo() throws ServletException{

    }
}
// {/fact}

