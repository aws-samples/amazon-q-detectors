# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-weak-hash-algorithm@v1.0 defects=1}
require 'digest'

class Utils 
    def noncompliant()
        # Noncompliant: MD5 is a weak hash algorithm.
        md5 = Digest::MD5.hexdigest('content')
    end
end
# {/fact}
