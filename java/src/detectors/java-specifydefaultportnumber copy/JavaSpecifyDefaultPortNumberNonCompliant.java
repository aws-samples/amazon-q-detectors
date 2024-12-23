// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specifydefaultportnumber@v1.0 defects=1}
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.net.URI;
import java.nio.channels.Channel;

class JavaSpecifyDefaultPortNumberNonCompliant {

    private Channel createChannelNonCompliant(URI uri) {
        // Noncompliant: default value for the port number is not specified.
        return NettyChannelBuilder.forAddress(uri.getHost(), uri.getPort())
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
    }
}
// {/fact}
