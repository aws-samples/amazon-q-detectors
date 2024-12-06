// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androiduselayoutinflater@v1.0 defects=0}
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import android.view.LayoutInflater;
import java.time.Month;

public abstract class AndroidUseLayoutInflatorCompliant extends BaseAdapter {

    static final int MAXIMUM_WEEKS = Calendar.getInstance().getMaximum(Calendar.WEEK_OF_MONTH);

    // Compliant: Uses `LayoutInflater.from()` to obtain a `LayoutInflater`, following Android best practices for view inflation.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView day = (TextView) convertView;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            day = (TextView) layoutInflater.inflate(11, parent, false);
        }
        return convertView;
    }
}
// {/fact}
