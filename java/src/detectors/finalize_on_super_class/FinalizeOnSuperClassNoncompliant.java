// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-finalize-on-super-class-ignored@v1.0 defects=1}
import java.io.BufferedReader;
import java.io.IOException;

public class FinalizeOnSuperClassNoncompliant {
    protected abstract class FeedParser {
        @Override
        protected abstract void finalize() throws IOException;
    }

    protected abstract class ETLFeedParser extends FeedParser {
        private BufferedReader feedReader;
        // Noncompliant: Overridden finalize method doesn't call super.finalize(), potentially leaving superclass resources uncleaned.
        @Override
        protected void nonCompliant() throws IOException {
            feedReader.close();
        }
    }
}
// {/fact}
