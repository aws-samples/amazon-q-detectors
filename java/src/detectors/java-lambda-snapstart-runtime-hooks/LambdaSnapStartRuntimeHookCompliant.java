// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-lambda-snapstart-runtime-hooks@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;
import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;

@Slf4j
public class LambdaSnapStartRuntimeHookCompliant {
    static class HooksAwareObject implements Resource {
        @Override
        public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {

        }

        @Override
        public void afterRestore(Context<? extends Resource> context) throws Exception {

        }
    }

    HooksAwareObject hooks = new HooksAwareObject();

    // Compliant: Lambda SnapStart runtime hooks registered using a pre-initialized object, ensuring consistent state across invocations.
    void compliant() {
        Core.getGlobalContext().register(this.hooks);
    }

}
// {/fact}
