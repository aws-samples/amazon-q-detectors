# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=multilanguage-avoid-hardcoded-dns@v1.0 defects=1}
def noncompliant
  # Noncompliant: Using hardcoded IP address with low SLA and lack of resilience to AZ isolation failures.
  ip_address = "10.4.4.9"
  return ip_address
end
# {/fact}
