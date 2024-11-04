# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-cookie-store-session-security-attributes@v1.0 defects=1}
# Noncompliant: `httponly` is set to `false`.
 Rails.application.config.session_store :cookie_store, key: '_rails3_session', httponly: false, domain: :all
# {/fact}
