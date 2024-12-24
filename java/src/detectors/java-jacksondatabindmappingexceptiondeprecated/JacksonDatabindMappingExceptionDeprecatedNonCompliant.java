// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jacksondatabindmappingexceptiondeprecated@v1.0 defects=1}
package com.msgilligan.bitcoinj.json.conversion;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.bitcoinj.core.Block;
import org.bitcoinj.core.Context;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.ProtocolException;

import java.io.IOException;

public class JacksonDatabindMappingExceptionDeprecatedCompliant extends JsonDeserializer<Block> {
    private final Context context;

    @Override
    public Block nonCompliant(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken token = p.getCurrentToken();
        switch (token) {
            case VALUE_STRING:
                try {
                    byte[] payload = HexUtil.hexStringToByteArray(p.getValueAsString()); // convert  to hex
                    return context.getParams().getDefaultSerializer().makeBlock(payload);
                } catch (ProtocolException e) {
                    throw new InvalidFormatException("Invalid Block", p.getValueAsString(), Block.class, e);
                }
            default:
                // Noncompliant: Continuing to use deprecated methods like `mappingException()` can lead to compatibility issues with future library versions.
                throw ctxt.mappingException(Block.class, token);
        }
    }
}
// {/fact}