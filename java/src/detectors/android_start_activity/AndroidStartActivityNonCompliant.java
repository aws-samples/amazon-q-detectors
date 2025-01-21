// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidstartactivity@v1.0 defects=1}
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.List;

public final class AndroidStartActivityNonCompliant {
    private Context context;
    private String text;
    private Uri uri;
    private String mimeType;
    private List<String> urlList;

    public AndroidStartActivityNonCompliant(Context context, String text, Uri uri, String mimeType, List<String> urlList) {
        this.context = context;
        this.text = text;
        this.uri = uri;
        this.mimeType = mimeType;
        this.urlList = urlList;
    }

    private String buildText() {
        return text + (urlList != null ? " " + String.join(", ", urlList) : "");
    }

    public void nonCompliant() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType(this.mimeType);

        shareIntent.putExtra(Intent.EXTRA_TEXT, buildText());
        if (this.uri != null) {
            shareIntent.putExtra(Intent.EXTRA_STREAM, this.uri);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        } else {
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        }
        // Noncompliant: Checks are not applied to validate if an application extists to handle the implicit intent.
        this.context.startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
// {/fact}
