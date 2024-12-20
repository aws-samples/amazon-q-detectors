// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-butterknifeinjectviewdeprecated@v1.0 defects=0}
package org.xbmc.kore.ui;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.Resources;
import android.widget.ImageView;

import butterknife.*;

abstract public class ButterKnifeInjectViewDeprecatedCompliant extends Fragment {

    @Override
    public View compliant(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null || inflater == null) {
            return null;
        }

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_info, container, false);

        // Compliant: The `ButterKnife.bind` following best practices and using the latest recommended tools for UI development.
        ButterKnife.bind(this, root);

        Resources resources = getActivity().getResources();

        DataHolder dataHolder = getDataHolder();

        if(!dataHolder.getSquarePoster()) {
            posterImageView.getLayoutParams().width =
                    resources.getDimensionPixelSize(R.dimen.detail_poster_width_nonsquare);
            posterImageView.getLayoutParams().height =
                    resources.getDimensionPixelSize(R.dimen.detail_poster_height_nonsquare);
        }

        return root;
    }
}
// {/fact}