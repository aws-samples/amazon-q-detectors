// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-butterknifeinjectviewdeprecated@v1.0 defects=1}
package org.xbmc.kore.ui;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.*;

abstract public class ButterKnifeInjectViewDeprecatedNonCompliant extends Fragment {

    @Override
    public View non_compliant(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null || inflater == null) {
            return null;
        }

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_info, container, false);
        // Noncompliant: Using the deprecated `ButterKnife.inject()` may lead to compatibility issues with newer android versions.
        ButterKnife.inject(this, root);
        return root;
    }
}
// {/fact}