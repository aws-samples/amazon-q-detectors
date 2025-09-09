// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-simplifyjsonarraycreation@v1.0 defects=1}
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class SimplifyJsonArrayCreationNonCompliant {

    private static final Logger logger = LoggerFactory.getLogger(SimplifyJsonArrayCreationNonCompliant.class);
    Gson gson;

    public List<String> nonCompliant(JsonObject message) {
        JsonArray items = message.getAsJsonArray("key");
        List<String> list = new ArrayList<>();
        // Noncompliant: JsonArray is deserialized to construct a list of items by iterating in a loop.
        for (JsonElement item : items) {
            list.add(gson.fromJson(item, String.class));
        }
        return list;
    }
}
// {/fact}
