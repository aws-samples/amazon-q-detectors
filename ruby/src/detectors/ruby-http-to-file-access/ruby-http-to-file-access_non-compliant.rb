# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-http-to-file-access@v1.0 defects=1}
require "net/http"

def noncompliant

    resp = Net::HTTP.new("https://example.com").get("/script").body

    file = File.open("/local/script", "w")
    # Noncompliant: Writing external content directly to a file without validation.
    file.write(resp)

end
# {/fact}
