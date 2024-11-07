# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-validation-regex@v1.0 defects=1}
class Account < ActiveRecord::Base
    # Noncompliant: `Ruby regex behavior is multiline by default. `\A` has not been used indicate the beginning of a line and `\Z` has not been used to denote the end of a line.
    validates :username, :length => 6..20, :format => /^[a-zA-Z]+$/
end
# {/fact}
