// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specifydefaultportnumber@v1.0 defects=0}
import io.grpc.Channel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.net.URI;

class UnspecifiedDefaultValueCompliant {

    // Compliant: Default value for the port number is specified.
    private Channel createChannelCompliant(URI uri) {
        int port = uri.getPort();
        if (port == -1) {
            port = 11984;
        }
        return NettyChannelBuilder.forAddress(uri.getHost(), port)
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
    }
}
// {/fact}
