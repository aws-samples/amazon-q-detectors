# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-http-to-file-access@v1.0 defects=0}
require "net/http"
require 'tempfile'

def noncompliant

    resp = Net::HTTP.new("https://example.com").get("/script").body

    Tempfile.create(['script', '.tmp']) do |file|
        # Compliant: Writing to a temporary file is safe. 
        file.write(resp)
    end
end
# {/fact}
