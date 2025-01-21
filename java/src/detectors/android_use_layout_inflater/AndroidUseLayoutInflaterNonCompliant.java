// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androiduselayoutinflater@v1.0 defects=1}
import android.app.Activity;
import android.content.Context;
import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class AndroidUseLayoutInflaterNonCompliant {

    public ViewHolder nonCompliant(ViewGroup parent, int viewType) {
        // Noncompliant: UI elements added programmatically.
        return new ViewHolder(new TextView(parent.getContext()));
    }
}
// {/fact}
