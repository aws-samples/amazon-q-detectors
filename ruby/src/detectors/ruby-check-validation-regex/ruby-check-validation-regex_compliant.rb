# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-check-validation-regex@v1.0 defects=0}
class Account < ActiveRecord::Base
    # Compliant: Ruby regex behavior is multiline by default. `\A` has been used to indicate the beginning of a line and `\Z` has been used to denote the end of a line.
    validates :username, :length => 6..20, :format => /\A[a-zA-Z]+\z/
end
# {/fact}
