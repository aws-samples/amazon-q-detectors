// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-jax-endpoint-usage@v1.0 defects=0}
import javax.ws.rs._
import javax.ws.rs.core.Response
import org.apache.commons.text.StringEscapeUtils
import org.owasp.encoder.Encode
import scala.util.Try
import scala.util.Success
import scala.util.Failure

@Path("/users")
class InsecureJaxEndpointCompliant {

  @Path("/greet/{name}")
  @GET
  def insecureJaxEndpointCompliant(@PathParam("name") name: String): String = {
    Try {
      if (name == null || name.trim.isEmpty) {
        throw new IllegalArgumentException("Name cannot be empty")
      }
      // Compliant: Proper input validation and sanitization.
      val sanitizedName = Encode.forHtml(StringEscapeUtils.unescapeJava(name.trim))

      s"Hello, $sanitizedName! Welcome to our service."
    } match {
      case Success(greeting) => greeting
      case Failure(e) => throw new WebApplicationException(
        s"Invalid input: ${e.getMessage}",
        Response.Status.BAD_REQUEST
      )
    }
  }

}
// {/fact}
