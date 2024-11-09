// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-jax-endpoint-usage@v1.0 defects=1}
import javax.ws.rs._

@Path("/users")
class InsecureJaxEndpointNoncompliant {

  @Path("/greet/{name}")
  @GET
  def insecureJaxEndpointNoncompliant(@PathParam("name") name: String): String = {
    // Noncompliant: Direct string concatenation with user input.
    "Hello, " + name + "! Welcome to our service."
  }

}
// {/fact}
