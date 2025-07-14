# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=multilanguage-avoid-hardcoded-dns@v1.0 defects=0}
def compliant
  # Compliant: Using DNS endpoint instead of hardcoded IP address for better resilience.
  "dns.example.com"
end
# {/fact}
