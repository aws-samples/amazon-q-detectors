// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-simplifyjsonarraycreation@v1.0 defects=1}

import android.os.Parcel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import stubs.Item;

class SimplifiableCodeNoncompliant {

    Gson gson;

    // Noncompliant: JsonArray is deserialized to construct a list of items by iterating in a loop.
    public List<String> getItemKeysNonCompliant(JsonObject message) {
        JsonArray items = message.getAsJsonArray("key");
        List<String> list = new ArrayList<>();
        for (JsonElement item : items) {
            list.add(gson.fromJson(item, String.class));
        }
        return list;
    }
}
// {/fact}
