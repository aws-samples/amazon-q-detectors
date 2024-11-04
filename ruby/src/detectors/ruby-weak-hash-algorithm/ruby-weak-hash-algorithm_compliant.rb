# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-weak-hash-algorithm@v1.0 defects=0}
require 'digest'

class Utils 
    def compliant()
        # Compliant: SHA256 is a secure hash algorithm. 
        sha256 = Digest::SHA256.hexdigest('content')
    end
end
# {/fact}
