// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specifydefaultportnumber@v1.0 defects=0}
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.net.URI;
import java.nio.channels.Channel;

class JavaSpecifyDefaultPortNumberCompliant {

    private Channel createChannelCompliant(URI uri) {
        int port = uri.getPort();
        // Compliant: default value for the port number is specified.
        if (port == -1) {
            port = 11984;
        }
        return NettyChannelBuilder.forAddress(uri.getHost(), port)
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
    }
}
// {/fact}
