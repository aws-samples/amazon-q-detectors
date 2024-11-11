// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cross-site-request-forgery@v1.0 defects=0}
import play.api.mvc.EssentialFilter
import play.filters.cors.CORSFilter
import javax.inject.{Inject, Singleton}
import play.filters.csrf.CSRFFilter
import play.api.http.HttpFilters
import akka.stream.Materializer

@Singleton
class CrossSiteRequestForgeryCompliant @Inject() (
                                                   csrfFilter: CSRFFilter,
                                                   corsFilter: CORSFilter
                                                 )(implicit val mat: Materializer) extends HttpFilters {

  // Compliant: Not bypassing `CSRF` protection for trusted origins.
  private val bypassCorsTrustedOrigins: Boolean = false

  def filters: Seq[EssentialFilter] = {
    if (!bypassCorsTrustedOrigins) {
      Seq(csrfFilter, corsFilter)
    } else {
      Seq(csrfFilter)
    }
  }

}
// {/fact}
