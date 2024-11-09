// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cross-site-request-forgery@v1.0 defects=1}
import play.api.mvc.EssentialFilter
import play.filters.cors.CORSFilter
import javax.inject.{Inject, Singleton}
import play.filters.csrf.CSRFFilter
import play.api.http.HttpFilters
import akka.stream.Materializer

@Singleton
class CrossSiteRequestForgeryNoncompliant @Inject() (
                                                corsFilter: CORSFilter
                                              )(implicit val mat: Materializer) extends HttpFilters {

  // Noncompliant: Bypassing `CSRF` protection for trusted origins.
  val bypassCorsTrustedOrigins: Boolean = true

  def filters: Seq[EssentialFilter] = {
    if (bypassCorsTrustedOrigins) {
      Seq(corsFilter)
    } else {
      Seq.empty
    }
  }

}
// {/fact}
