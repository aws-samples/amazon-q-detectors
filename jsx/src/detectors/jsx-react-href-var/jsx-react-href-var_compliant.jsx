// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-react-href-var@v1.0 defects=0}
function compliant() {
  collaborationSectionData.paragraphs.map((item, i) => (
    // Compliant: `href` is assigned a direct value.
    <div>  
      <a href={item.value}>click</a>
    </div>
  ));
}
// {/fact}