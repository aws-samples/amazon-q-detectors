// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-lambda-snapstart-runtime-hooks@v1.0 defects=1}
import lombok.extern.slf4j.Slf4j;
import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;

@Slf4j
public class LambdaSnapStartRuntimeHookNoncompliant {

    static class HooksAwareObject implements Resource {
        @Override
        public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {

        }

        @Override
        public void afterRestore(Context<? extends Resource> context) throws Exception {

        }
    }

    HooksAwareObject hooks = new HooksAwareObject();

    // Noncompliant: Lambda SnapStart runtime hooks registered without proper exception handling, risking unhandled errors during checkpoint or restore.
    void noncompliant() {
        Core.getGlobalContext().register(new HooksAwareObject());
    }

}
// {/fact}
