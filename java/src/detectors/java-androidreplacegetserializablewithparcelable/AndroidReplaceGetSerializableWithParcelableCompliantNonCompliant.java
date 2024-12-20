// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidreplacegetserializablewithparcelable@v1.0 defects=1}
package rules.inefficient_apis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.R;
import android.widget.TextView;

class AndroidReplaceGetSerializableWithParcelableCompliantNonCompliant extends Activity {

    public void non_compliant(Bundle savedInstanceState) {
        Intent intent = getIntent();
        // Noncompliant: Using `Serializable` for data transfer in android can lead to significant performance overhead.
        String message = (String) intent.getSerializableExtra("message");
        TextView receiverMessage = (TextView) findViewById(R.id.received_message);
        receiverMessage.setText(message);
    }
}
// {/fact}