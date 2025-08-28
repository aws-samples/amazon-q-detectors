// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-server-side-request-forgery@v1.0 defects=1}
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import java.net.URL

// Noncompliant: User input data passed to `respondText()`.
fun ssrf_noncompliant() {
    embeddedServer(Netty, port = 8080) {
        routing {
            post("/proxy/{url}") {
                val url = call.request.queryParameters["url"]
                if (url != null) {
                    val data = URL(url).readText()
                    call.respondText(data)
                }
            }
        }
    }.start(wait = true)
}
// {/fact}