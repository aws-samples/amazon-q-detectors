# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-cookie-store-session-security-attributes@v1.0 defects=0}
# Compliant: No insecure configuration for 'httponly' present.
Rails.application.config.session_store :cookie_store,
                                       key: '_your_app_session',
                                       domain: :all,
                                       httponly: true,
                                       secure: Rails.env.production?,
                                       expire_after: 30.minutes,
                                       same_site: :lax 
# {/fact}
