// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidusereadparcelableinsteadofreadvalue@v1.0 defects=1}
import android.os.Parcel;

public class AndroidUseReadParcelableInsteadOfReadValueNonCompliant {

    public String nonCompliant(Parcel input) {
        // Noncompliant: Output of readValue is type cast to String.
        try {
            return (String) input.readValue(String.class.getClassLoader());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
// {/fact}
