// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-catch-specifically-thrown-exception@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MissingSpecificallyThrownExceptionHandlingCompliant {

    // Compliant: Catch block handles exception `SomeException`.
    public void compliant() {
        try {
            doSomething();
            throw new SomeException();
        } catch (IndexOutOfBoundsException e) {
            log.error(e.getMessage());
        } catch (SomeException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void doSomething() {
    }

    public class SomeException extends Exception {
    }
}
// {/fact}
