# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection-active-record@v1.0 defects=1}
require 'active_record'

class Product < ActiveRecord::Base
  def noncompliant
    # Noncompliant: Using string interpolation in ActiveRecord find methods can lead to SQL injection.
    Product.find(:all, :order => params[:order])
  end
end
# {/fact}
