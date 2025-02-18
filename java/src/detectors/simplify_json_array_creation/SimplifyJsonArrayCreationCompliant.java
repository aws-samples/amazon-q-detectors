// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-simplifyjsonarraycreation@v1.0 defects=0}
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class SimplifyJsonArrayCreationCompliant {

    private static final Logger logger = LoggerFactory.getLogger(SimplifyJsonArrayCreationNonCompliant.class);
    Gson gson;

    public List<stubs.Item> compliant(JsonObject message) {
        JsonArray items = message.getAsJsonArray("key");
        // Compliant: JsonArray is deserialized to construct a list of items without iterating in a loop.
        return gson.fromJson(items, new TypeToken<List<String>>(){}.getType());
    }
}
// {/fact}
