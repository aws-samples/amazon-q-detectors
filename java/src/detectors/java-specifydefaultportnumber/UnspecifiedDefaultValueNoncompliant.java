// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specifydefaultportnumber@v1.0 defects=1}

import io.grpc.Channel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.net.URI;

class UnspecifiedDefaultValueNoncompliant {

    // Noncompliant: Default value for the port number is not specified.
    private Channel createChannelNonCompliant(URI uri) {
        return NettyChannelBuilder.forAddress(uri.getHost(), uri.getPort())
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
    }

}
// {/fact}
