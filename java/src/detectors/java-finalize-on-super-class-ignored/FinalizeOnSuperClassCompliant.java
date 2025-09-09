// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-finalize-on-super-class-ignored@v1.0 defects=0}
import java.io.BufferedReader;
import java.io.IOException;

public class FinalizeOnSuperClassCompliant {

    protected abstract class FeedParser {
        @Override
        protected void finalize() throws IOException {
            System.out.println("finalize-class");
        }
    }

    protected abstract class ETLFeedParserCompliant extends FeedParser {
        private BufferedReader feedReader;
        @Override
        // Compliant: Overridden finalize method calls super.finalize(), ensuring proper cleanup of superclass resources.
        protected void finalize() throws IOException {
            try {
                feedReader.close();
            }
            finally {
                super.finalize();
            }
        }
    }
}
// {/fact}
