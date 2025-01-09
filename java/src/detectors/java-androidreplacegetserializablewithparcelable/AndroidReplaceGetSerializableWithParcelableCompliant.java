// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidreplacegetserializablewithparcelable@v1.0 defects=0}
package rules.inefficient_apis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.R;
import android.widget.TextView;

class AndroidReplaceGetSerializableWithParcelableCompliant extends Activity {

    public void compliant(Bundle savedInstanceState) {
        Intent intent = getIntent();
        // Compliant: The `getStringExtra()` method is more efficient than the general-purpose serialization approach.
        String message = intent.getStringExtra("message");
        TextView receiverMessage = (TextView) findViewById(R.id.received_message);
        receiverMessage.setText(message);
    }
}
// {/fact}