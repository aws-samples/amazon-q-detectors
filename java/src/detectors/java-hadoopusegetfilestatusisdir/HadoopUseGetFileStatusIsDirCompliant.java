// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hadoopusegetfilestatusisdir@v1.0 defects=0}
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.fs.FileSystem;
import org.apache.nutch.segment.SegmentReader.SegmentReaderStats;
import org.apache.nutch.crawl.CrawlDatum;
import org.apache.commons.logging.Log;
import org.apache.hadoop.conf.Configuration;
import org.apache.commons.logging.LogFactory;

public class HadoopUseGetFileStatusIsDirCompliant {

    public static final Log LOG = LogFactory.getLog(HadoopUseGetFileStatusIsDirNonCompliant.class);
    long recNo = 0L;
    private boolean co, fe, ge, pa, pd, pt;
    private FileSystem fs;

    // Compliant: Using non-deprecated way of checking directory `FileSystem.getFileStatus().isDir()`.
    public void compliant(Path segment, final SegmentReaderStats stats) throws Exception {
        SequenceFile.Reader[] readers = SequenceFileOutputFormat.getReaders(new Configuration(), new Path(segment, CrawlDatum.GENERATE_DIR_NAME));
        long cnt = 0L;
        Text key = new Text();
        for (int i = 0; i < readers.length; i++) {
            while (readers[i].next(key)) cnt++;
            readers[i].close();
        }
        stats.generated = cnt;
        Path fetchDir = new Path(segment, CrawlDatum.FETCH_DIR_NAME);
        if (fs.exists(fetchDir) && fs.getFileStatus(fetchDir).isDir()) {
            cnt = 0L;
            long start = Long.MAX_VALUE;
            long end = Long.MIN_VALUE;
            CrawlDatum value = new CrawlDatum();
            stats.start = start;
            stats.end = end;
            stats.fetched = cnt;
        }
    }
}
// {/fact}
