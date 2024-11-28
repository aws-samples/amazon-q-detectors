// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-simplifyjsonarraycreation@v1.0 defects=0}

import android.os.Parcel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import stubs.Item;

class SimplifiableCodeCompliant {

    Gson gson;

    // Compliant: JsonArray is deserialized to construct a list of items without iterating in a loop.
    public List<Item> getItemKeysCompliant(JsonObject message) {
        JsonArray items = message.getAsJsonArray("key");
        return gson.fromJson(items, new TypeToken<List<String>>(){}.getType());
    }
}
// {/fact}
