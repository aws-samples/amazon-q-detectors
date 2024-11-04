# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-json-entity-escape@v1.0 defects=1}
def noncompliant 
    # Noncompliant: HTML entity escaping has been disabled.
    ActiveSupport.escape_html_entities_in_json = false
end
# {/fact}
