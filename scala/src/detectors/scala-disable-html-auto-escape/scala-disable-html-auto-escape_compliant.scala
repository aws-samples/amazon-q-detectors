// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-disable-html-auto-escape@v1.0 defects=0}
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters

class DisableHtmlAutoEscapeCompliant extends WebPage {

  def disableHtmlAutoEscapeCompliant(pageParameters: PageParameters): Unit = {
    // Compliant: Auto escape is enabled for this label.
    add(new Label("test").setEscapeModelStrings(true))
  }

}
// {/fact}
