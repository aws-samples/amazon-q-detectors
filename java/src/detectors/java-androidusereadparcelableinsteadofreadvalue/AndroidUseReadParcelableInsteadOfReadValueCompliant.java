// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-androidusereadparcelableinsteadofreadvalue@v1.0 defects=0}
import android.os.Parcel;

public class AndroidUseReadParcelableInsteadOfReadValueCompliant {

    public String compliant(Parcel input) {
        // Compliant: `readParcelable` is used to read the Parcel input, which does not require an explicit type cast.
        try {
            return input.readParcelable(String.class.getClassLoader());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
// {/fact}
