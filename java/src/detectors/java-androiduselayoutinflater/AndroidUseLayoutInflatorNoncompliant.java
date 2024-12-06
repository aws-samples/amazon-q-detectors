// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androiduselayoutinflater@v1.0 defects=1}
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import android.view.LayoutInflater;
import java.time.Month;

public abstract  class AndroidUseLayoutInflatorNoncompliant extends BaseAdapter {

    static final int MAXIMUM_WEEKS = Calendar.getInstance().getMaximum(Calendar.WEEK_OF_MONTH);
    private int textViewSize;

    // Noncompliant: Directly creates `TextView` instead of using `LayoutInflater`, which may not apply proper styles and themes.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView day = (TextView) convertView;
        if (convertView == null) {
            day = new TextView(parent.getContext());
            day.setHeight(textViewSize);
        }
        return day;
    }
}
// {/fact}
