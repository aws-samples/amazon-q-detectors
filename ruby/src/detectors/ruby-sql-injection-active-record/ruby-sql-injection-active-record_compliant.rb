# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=ruby-sql-injection-active-record@v1.0 defects=0}
require 'active_record'

class Product < ActiveRecord::Base
  def compliant
    # Compliant: Using hash-based conditions to prevent SQL injection.
    Product.find(:all, :conditions => { :admin => 1 }, :order => 'name ASC')
  end
end
# {/fact}
