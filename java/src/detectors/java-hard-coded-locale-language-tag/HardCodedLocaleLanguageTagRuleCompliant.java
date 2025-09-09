// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hard-coded-locale-language-tag@v1.0 defects=0}
import java.util.Locale;
import com.amazon.alexacustomerlocationattributionmgmtservice.model.GetDeviceLocalesRequest;
import com.amazon.alexacustomerlocationattributionmgmtservice.model.GetDeviceLocalesResponse;
import com.amazon.alexacustomerlocationattributionmgmtservice.module.lib.AlexaCLAMSAdapter;

public class HardCodedLocaleLanguageTagRuleCompliant {

    // Compliant: Dynamically fetching device locales from CLAMS.
    public void compliantLocaleUsage(AlexaCLAMSAdapter alexaCLAMSAdapter, String deviceAccountId) {
        try {
            GetDeviceLocalesResponse deviceLocalesResponse =
                    alexaCLAMSAdapter.getDeviceLocales(
                            GetDeviceLocalesRequest.builder()
                                    .withDeviceAccountId(deviceAccountId)
                                    .build()
                    );
            Locale preferredLocale = deviceLocalesResponse.getDeviceLocales()
                    .getDeviceSettingLocales()
                    .stream()
                    .findFirst()
                    .map(Locale::forLanguageTag)
                    .orElse(Locale.getDefault());
        } catch (Exception e) {
            Locale defaultLocale = Locale.getDefault();
        }
    }
}
// {/fact}
