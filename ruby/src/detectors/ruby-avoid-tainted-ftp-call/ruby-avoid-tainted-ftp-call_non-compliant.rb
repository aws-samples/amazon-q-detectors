# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-avoid-tainted-ftp-call@v1.0 defects=1}
require 'net/ftp'

class UsersController < ApplicationController
    def noncompliant 
        host = params[:host]
        # Noncompliant: Using user controlled input being used for an ftp session.
        ftp = Net::FTP.new(host)

        ftp.login(ENV['FTP_USERNAME'], ENV['FTP_PASSWORD'])

        begin
            ftp.getbinaryfile("/tmp/config", "local/ftp_config")
            render plain: "File downloaded successfully. "
        rescue Net::FTPPermError => e
            render plain: "Permission error: #{e.message}", status: :forbidden
        ensure
            ftp.close if ftp
        end
    end
end
# {/fact}
